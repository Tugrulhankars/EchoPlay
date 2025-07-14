package org.echoplay.echoplay.repository;

import org.echoplay.echoplay.entity.MediaFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaFileRepository extends JpaRepository<MediaFile,Long> {

    List<MediaFile> findMediaFileByCategoryId(Long categoryId);


}
