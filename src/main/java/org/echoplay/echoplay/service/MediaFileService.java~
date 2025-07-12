package org.echoplay.echoplay.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaFileService {

    String uploadMediaFile(MultipartFile file);
    String deleteMediaFile(String fileName);
    String getMediaFileUrlById(Long id);
    List<String> getAllMediaFileUrlsByCategoryId(Long categoryId);
    List<String> getAllMediaFileUrlsByPerformerId(Long performerId);

}
