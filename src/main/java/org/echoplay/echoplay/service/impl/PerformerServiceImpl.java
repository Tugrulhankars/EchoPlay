package org.echoplay.echoplay.service.impl;

import org.echoplay.echoplay.dto.request.CreatePerformerRequest;
import org.echoplay.echoplay.entity.Performer;
import org.echoplay.echoplay.repository.PerformerRepository;
import org.echoplay.echoplay.service.PerformerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformerServiceImpl implements PerformerService {
    private final PerformerRepository performerRepository;

    public PerformerServiceImpl(PerformerRepository performerRepository) {
        this.performerRepository = performerRepository;
    }

    @Override
    public String createPerformer(CreatePerformerRequest request) {
        Performer performer=new Performer();
        performer.setFirstName(request.getFirstName());
        performer.setLastName(request.getLastName());
        performer.setImageUrl(request.getImageUrl());

        performerRepository.save(performer);
        return "Success";
    }

    @Override
    public List<Performer> getAllPerformers() {
        List<Performer> performers=performerRepository.findAll();
        return performers;
    }

    @Override
    public Performer getPerformerById(Long id) {
        Performer performer=performerRepository.findById(id).get();
        return performer;
    }

    @Override
    public Performer findPerformerByFullName(String firstName, String lastName) {
        Performer performer=performerRepository.findPerformerByFullName(firstName,lastName);
        if(performer!=null){
            return performer;
        }
        return null;
    }
}
