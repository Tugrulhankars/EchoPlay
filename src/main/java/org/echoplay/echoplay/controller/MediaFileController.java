package org.echoplay.echoplay.controller;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.echoplay.echoplay.dto.request.UploadMediaFileRequest;
import org.echoplay.echoplay.service.MediaFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/media-file")
public class MediaFileController {

    private final MediaFileService mediaFileService;

    public MediaFileController(MediaFileService mediaFileService) {
        this.mediaFileService = mediaFileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadMediaFile(@RequestPart MultipartFile file, @RequestBody UploadMediaFileRequest request) {

        return ResponseEntity.ok("");
    }
}
