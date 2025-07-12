package org.echoplay.echoplay.repository;

import org.echoplay.echoplay.entity.MediaFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaFileRepository extends JpaRepository<MediaFile,Long> {
}
