package com.formacion.block11uploaddownloadfiles.application;

import com.formacion.block11uploaddownloadfiles.domain.File;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

public interface StorageService {
	Path load(String filename);
	Resource loadAsResourceById (String id);
	Resource loadAsResourceByFilename (String filename);
	File store(MultipartFile file);
	void setPath(String path) throws Exception;
	void deleteAll();
	void init();
}
