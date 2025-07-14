package org.echoplay.echoplay.service.impl;

import jakarta.transaction.Transactional;
import org.echoplay.echoplay.dto.request.UploadMediaFileRequest;
import org.echoplay.echoplay.dto.response.MediaFileResponse;
import org.echoplay.echoplay.entity.Category;
import org.echoplay.echoplay.entity.MediaFile;
import org.echoplay.echoplay.entity.Performer;
import org.echoplay.echoplay.repository.CategoryRepository;
import org.echoplay.echoplay.repository.MediaFileRepository;
import org.echoplay.echoplay.service.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class MediaFileServiceImpl implements MediaFileService {
    private final AwsS3Service awsS3Service;
    private final MediaFileRepository mediaFileRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final PerformerService performerService;

    public MediaFileServiceImpl(AwsS3Service awsS3Service, MediaFileRepository mediaFileRepository, UserService userService, CategoryService categoryService, PerformerService performerService) {
        this.awsS3Service = awsS3Service;
        this.mediaFileRepository = mediaFileRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.performerService = performerService;
    }

    @Transactional
    @Override
    public String uploadMediaFile(MultipartFile file, UploadMediaFileRequest request) {
        Category category = categoryService.getCategoryById(request.getCategoryId());
        Performer performer = performerService.findPerformerByFullName(
                request.getPerformerFirstName(), request.getPerformerLastName());

        String s3Key = null;
        try {
            // 1. S3'e yükleme
            Long userId = 1L; // Gerçek kullanıcı id'si olmalı
            s3Key = awsS3Service.uploadMultipartFile(file, userId); // Bu metot key döndürmeli!

            // 2. Medya nesnesi oluştur
            MediaFile mediaFile = new MediaFile();
            mediaFile.setFileName(request.getFileName());
            mediaFile.setApproved(false);
            mediaFile.setDescription(request.getDescription());
            mediaFile.setImageUrl(request.getImageUrl());
            mediaFile.setTitle(request.getTitle());
            mediaFile.setPerformer(performer);
            mediaFile.setCategory(category);
            mediaFile.setMediaFileUrl(s3Key);
            //mediaFile.setS3Key(s3Key); // Yeni alan: S3 dosya yolu
            mediaFileRepository.save(mediaFile);

            return "Media file uploaded and saved successfully.";

        } catch (Exception e) {
            // 3. Veritabanı kaydı yapılmadı ama S3'e yükleme olduysa geri al
            if (s3Key != null) {
                try {
                    awsS3Service.deleteFile(s3Key);
                } catch (Exception deleteEx) {
                    System.err.println("S3 temizleme hatası: " + deleteEx.getMessage());
                }
            }
            throw new RuntimeException("Dosya yükleme veya kayıt işlemi başarısız: " + e.getMessage(), e);
        }
    }


    @Override
    public String deleteMediaFile(String fileName) {
        return "";
    }

    @Override
    public String getMediaFileUrlById(Long id) {
        MediaFile mediaFile=mediaFileRepository.findById(id).get();
        String url=mediaFile.getMediaFileUrl();
        return url;
    }

    @Override
    public List<MediaFileResponse> getAllMediaFileByCategoryId(Long categoryId) {
        List<MediaFile> mediaFiles=mediaFileRepository.findMediaFileByCategoryId(categoryId);
        List<MediaFileResponse> mediaFileResponses=new ArrayList<>();
        for (MediaFile mediaFile:mediaFiles) {
            MediaFileResponse mediaFileResponse=new MediaFileResponse();
            mediaFileResponse.setId(mediaFile.getId());
            mediaFileResponse.setTitle(mediaFile.getTitle());
            mediaFileResponse.setDescription(mediaFile.getDescription());
            mediaFileResponse.setImageUrl(mediaFile.getImageUrl());
            mediaFileResponse.setFileName(mediaFile.getFileName());
            mediaFileResponse.setUploadedAt(mediaFile.getUploadedAt());
            mediaFileResponses.add(mediaFileResponse);
        }
        return mediaFileResponses;
    }



    @Override
    public List<MediaFileResponse> getAllMediaFileUrlsByPerformerId(Long performerId) {
        return List.of();
    }
}
