package org.echoplay.echoplay.service;

import org.echoplay.echoplay.dto.request.CreatePerformerRequest;
import org.echoplay.echoplay.entity.Performer;

import java.util.List;

public interface PerformerService {
    String createPerformer(CreatePerformerRequest request);
    List<Performer> getAllPerformers();
    Performer getPerformerById(Long id);
    Performer findPerformerByFullName(String firstName,String lastName);
}
