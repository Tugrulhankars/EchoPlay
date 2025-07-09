package org.echoplay.echoplay.service.impl;

import org.echoplay.echoplay.service.MediaFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class MediaFileServiceImpl implements MediaFileService {
    @Override
    public String uploadMediaFile(MultipartFile file) {
        return "";
    }

    @Override
    public String deleteMediaFile(String fileName) {
        return "";
    }

    @Override
    public String getMediaFileUrlById(Long id) {
        return "";
    }

    @Override
    public List<String> getAllMediaFileUrlsByCategoryId(Long categoryId) {
        return List.of();
    }

    @Override
    public List<String> getAllMediaFileUrlsByPerformerId(Long performerId) {
        return List.of();
    }
}
