package org.echoplay.echoplay.service.impl;

import org.echoplay.echoplay.service.AwsS3Service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.StorageClass;

import java.io.File;
import java.io.FileOutputStream;

@Service
public class AwsS3ServiceImpl implements AwsS3Service {
    private final S3Client s3Client;

    public AwsS3ServiceImpl(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public String uploadMultipartFile(MultipartFile file) {
        try {
            PutObjectRequest putObjectRequest=PutObjectRequest.builder()
                    .bucket("echoplay-bucket")
                    .key(file.getOriginalFilename())
                    .contentLength(file.getSize())
                    .build();
            s3Client.putObject(putObjectRequest,
                    RequestBody.fromBytes(file.getInputStream().readAllBytes()));
            return file.getOriginalFilename()+" uploaded successfully";
        } catch (Exception e) {
            return e.getMessage();

        }
    }

    @Override
    public String downloadFile(String fileName) {
        GetObjectRequest getObjectRequest=GetObjectRequest.builder()
                .bucket("echoplay-bucket")
                .key(fileName)
                .build();

        try {
            byte[] objectResponse=s3Client.getObject(getObjectRequest).readAllBytes();
            File file=new File(System.getProperty("user.home")+"/Downloads/"+fileName);
            FileOutputStream fileOutputStream=new FileOutputStream(file,false);
            fileOutputStream.write(objectResponse);
            fileOutputStream.close();
            return file.getAbsolutePath();
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteFile(String fileName) {
        DeleteObjectRequest deleteObjectRequest=DeleteObjectRequest.builder()
                .bucket("echoplay-bucket")
                .key(fileName)
                .build();
        s3Client.deleteObject(deleteObjectRequest);

    }

    @Override
    public String updateFile(String fileName, MultipartFile file) {
        try {
            PutObjectRequest putObjectRequest=PutObjectRequest.builder()
                    .bucket("echoplay-bucket")
                    .key(fileName)
                    .contentLength(file.getSize())
                    .build();
            s3Client.putObject(putObjectRequest,
                    RequestBody.fromBytes(file.getInputStream().readAllBytes()));
            return file.getOriginalFilename() +" updated successfully";
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
