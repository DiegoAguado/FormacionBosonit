package com.formacion.block11uploaddownloadfiles.repository;

import com.formacion.block11uploaddownloadfiles.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<File, Integer> {
    Optional<File> findFileByNombre(String nombre);
}
