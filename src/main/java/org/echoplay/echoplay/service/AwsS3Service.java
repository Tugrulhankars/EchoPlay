package org.echoplay.echoplay.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface AwsS3Service {
    //String generatePreSignedUrl(String fileName);
    String uploadMultipartFile(MultipartFile file);
    String downloadFile(String fileName);
    void deleteFile(String fileName);
    String updateFile(String fileName, MultipartFile file);
    
    // Stream için yeni metodlar
    String generatePreSignedUrl(String fileName, int expirationMinutes);
    InputStream streamFile(String fileName);
    String getStreamUrl(String fileName);

}
