package com.devatlant.training.conference.api;

import com.devatlant.training.conference.domain.Conference;
import com.devatlant.training.conference.domain.Talk;
import com.devatlant.training.conference.repository.ConferenceRepository;
import com.devatlant.training.conference.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author yevgen voronetski
 */
@RestController
public class ConferenceController {
    private final ConferenceRepository conferenceRepository;
    private final ConferenceService conferenceService;

    @Autowired
    public ConferenceController(ConferenceRepository conferenceRepository, ConferenceService conferenceService) {
        this.conferenceRepository = conferenceRepository;
        this.conferenceService = conferenceService;
    }

    @PostMapping("/conferences")
    public ResponseEntity<Conference> createConference(@RequestBody final Conference conference) {
        return ResponseEntity.ok(conferenceRepository.save(conference));
    }

    @GetMapping("/conferences")
    public ResponseEntity<Iterable<Conference>> getAllConferences() {
        return ResponseEntity.ok(conferenceRepository.findAll());
    }

    @PostMapping("/conferences/{conferenceId}/talks")
    public ResponseEntity<Talk> addTalk(@PathVariable final Long conferenceId, @RequestBody final Talk talk) {
        return ResponseEntity.ok(conferenceService.addTalk(conferenceId, talk));
    }
}
