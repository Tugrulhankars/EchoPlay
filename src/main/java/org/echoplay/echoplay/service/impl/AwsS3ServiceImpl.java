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
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.UUID;

@Service
public class AwsS3ServiceImpl implements AwsS3Service {
    private final S3Client s3Client;
    private final S3Presigner s3Presigner;

    public AwsS3ServiceImpl(S3Client s3Client) {
        this.s3Client = s3Client;
        this.s3Presigner = S3Presigner.builder().build();
    }

    @Override
    public String uploadMultipartFile(MultipartFile file,Long userId) {
        try {
            // Kullanıcıya özel bir key (path) oluştur
            String key = "user-" + userId + "/" + UUID.randomUUID() + "-" + file.getOriginalFilename();

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket("echoplay-bucket")
                    .key(key)
                    .contentType(file.getContentType())
                    .contentLength(file.getSize())
                    .build();

            s3Client.putObject(putObjectRequest,
                    RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
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

    @Override
    public String generatePreSignedUrl(String fileName, int expirationMinutes) {
        try {
            GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                    .signatureDuration(Duration.ofMinutes(expirationMinutes))
                    .getObjectRequest(GetObjectRequest.builder()
                            .bucket("echoplay-bucket")
                            .key(fileName)
                            .build())
                    .build();
            
            return s3Presigner.presignGetObject(presignRequest).url().toString();
        } catch (Exception e) {
            throw new RuntimeException("Pre-signed URL oluşturulamadı: " + e.getMessage());
        }
    }

    @Override
    public InputStream streamFile(String fileName) {
        try {
            GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                    .bucket("echoplay-bucket")
                    .key(fileName)
                    .build();
            
            return s3Client.getObject(getObjectRequest);
        } catch (Exception e) {
            throw new RuntimeException("Dosya stream edilemedi: " + e.getMessage());
        }
    }

    @Override
    public String getStreamUrl(String fileName) {
        // CloudFront URL'i döndür (eğer CloudFront kullanıyorsanız)
        // veya pre-signed URL
        return generatePreSignedUrl(fileName, 60); // 60 dakika geçerli
    }
}
