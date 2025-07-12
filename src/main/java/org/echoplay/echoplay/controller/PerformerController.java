package org.echoplay.echoplay.controller;


import org.echoplay.echoplay.dto.request.CreatePerformerRequest;
import org.echoplay.echoplay.entity.Performer;
import org.echoplay.echoplay.service.PerformerService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/performer")
public class PerformerController {
    private final PerformerService performerService;

    public PerformerController(PerformerService performerService) {
        this.performerService = performerService;
    }

    @PostMapping("/create")
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> createPerformer(@RequestBody CreatePerformerRequest request) {
        String response=performerService.createPerformer(request);
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Performer>> getAllPerformer(){
        List<Performer> performers=performerService.getAllPerformers();
        return ResponseEntity.ok(performers);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Performer> getPerformerById(Long id){
        Performer performer=performerService.getPerformerById(id);
        return ResponseEntity.ok(performer);
    }
}
