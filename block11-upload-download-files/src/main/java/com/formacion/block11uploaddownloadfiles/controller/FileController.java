package com.formacion.block11uploaddownloadfiles.controller;

import com.formacion.block11uploaddownloadfiles.application.StorageService;
import com.formacion.block11uploaddownloadfiles.domain.File;
import com.formacion.block11uploaddownloadfiles.storage.StorageException;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class FileController {
    @Autowired
    StorageService storageService;


    @GetMapping("/{id}")
    public ResponseEntity<Resource> downloadFileById(@PathVariable String id) {

        Resource file = storageService.loadAsResourceById(id);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    @GetMapping("/filename/{filename}")
    public ResponseEntity<Resource> downloadFileByFilename(@PathVariable String filename) {

        Resource file = storageService.loadAsResourceByFilename(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    @PostMapping("/")
    public ResponseEntity<File> uploadAnyFile(@RequestParam MultipartFile file,
                                              RedirectAttributes redirectAttributes
    ) throws StorageException {
        try {

            redirectAttributes.addFlashAttribute("mensaje",
                    "Has subido satisfactoriamente " + file.getName() + "!");
            return ResponseEntity.ok().body(storageService.store(file));

        } catch (StorageException e) {
            throw new StorageException(e.getMessage());
        }
    }

    @GetMapping("/setpath{path}")
    public ResponseEntity<String> setPath (@PathVariable String path) throws Exception {
        try{
            storageService.setPath(path);
            storageService.init();
            return ResponseEntity.ok().body("El nuevo directorio es: "+path);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    //
    @PostMapping("/upload/{tipo}")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file,
                                     @PathVariable String tipo) throws StorageException {
        try {
            String fileName = file.getOriginalFilename().toString();
            // Code to get characters from '.' until the end of de filename
            String fileType = fileName.substring(fileName.lastIndexOf('.') + 1);
            if (!tipo.equals(fileType)) {
                return ResponseEntity.internalServerError().body("Solo se permite subir ficheros con extensión '.txt'");
            } else {
                return ResponseEntity.ok().body(storageService.store(file));
            }
        } catch (StorageException e) {
            throw new StorageException(e.getMessage());
        }
    }

}
