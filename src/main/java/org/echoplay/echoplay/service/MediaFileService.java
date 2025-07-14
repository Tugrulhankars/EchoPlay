package org.echoplay.echoplay.service;

import org.echoplay.echoplay.dto.request.UploadMediaFileRequest;
import org.echoplay.echoplay.dto.response.MediaFileResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaFileService {

    String uploadMediaFile(MultipartFile file, UploadMediaFileRequest request);
    String deleteMediaFile(String fileName);
    String getMediaFileUrlById(Long id);
    List<MediaFileResponse> getAllMediaFileByCategoryId(Long categoryId);
    List<MediaFileResponse> getAllMediaFileUrlsByPerformerId(Long performerId);

}
