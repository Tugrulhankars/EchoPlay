package org.echoplay.echoplay.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.echoplay.echoplay.dto.request.CreatePerformerRequest;
import org.echoplay.echoplay.entity.Performer;
import org.echoplay.echoplay.service.PerformerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/performer")
@Tag(name = "Performer")
public class PerformerController {
    private final PerformerService performerService;

    public PerformerController(PerformerService performerService) {
        this.performerService = performerService;
    }

    @PostMapping("/create")
    @Operation(description = "Create Performer")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> createPerformer(CreatePerformerRequest request) {
        String response=performerService.createPerformer(request);
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    @Operation(description = "Get All Performers")
    public ResponseEntity<List<Performer>> getAllPerformer(){
        List<Performer> performers=performerService.getAllPerformers();
        return ResponseEntity.ok(performers);
    }

    @GetMapping("/getById/{id}")
    @Operation(description = "Get Performer By Id")
    public ResponseEntity<Performer> getPerformerById(Long id){
        Performer performer=performerService.getPerformerById(id);
        return ResponseEntity.ok(performer);
    }
}
