package org.echoplay.echoplay.service;

import org.springframework.web.multipart.MultipartFile;

public interface AwsS3Service {
    //String generatePreSignedUrl(String fileName);
    String uploadMultipartFile(MultipartFile file);
    String downloadFile(String fileName);
    void deleteFile(String fileName);
    String updateFile(String fileName, MultipartFile file);


}
