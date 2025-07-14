package org.echoplay.echoplay.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.echoplay.echoplay.dto.request.UploadMediaFileRequest;
import org.echoplay.echoplay.dto.response.MediaFileResponse;
import org.echoplay.echoplay.service.MediaFileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/media-file")
public class MediaFileController {

    private final MediaFileService mediaFileService;

    public MediaFileController(MediaFileService mediaFileService) {
        this.mediaFileService = mediaFileService;
    }

    @Operation(summary = "Upload Media File", description = "Upload media file with metadata")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Invalid Request")
    })
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadMediaFile(
            @RequestPart("file") MultipartFile file,
            @RequestPart("metadata") String metadataJson) throws JsonProcessingException {

        UploadMediaFileRequest metadata = new ObjectMapper().readValue(metadataJson, UploadMediaFileRequest.class);

        String result = mediaFileService.uploadMediaFile(file, metadata);
        return ResponseEntity.ok(result);
    }




    @GetMapping("/getByCategory/{id}")
    public ResponseEntity<List<MediaFileResponse>> getAllMediaFileByCategoryId(@PathVariable Long id) {
        return ResponseEntity.ok(mediaFileService.getAllMediaFileByCategoryId(id));
    }
}
