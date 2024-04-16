package com.devatlant.training.conference.api;

import com.devatlant.training.conference.domain.Conference;
import com.devatlant.training.conference.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yevgen voronetski
 */
@RestController
public class ConferenceController {
    private final ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceController(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @PostMapping("/conferences")
    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
        return ResponseEntity.ok(conferenceRepository.save(conference));
    }

    @GetMapping("/conferences")
    public ResponseEntity<Iterable<Conference>> getAllConferences() {
        return ResponseEntity.ok(conferenceRepository.findAll());
    }
}
