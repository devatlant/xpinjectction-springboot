package com.devatlant.training.conference.api;

import com.devatlant.training.conference.domain.Conference;
import com.devatlant.training.conference.domain.Talk;
import com.devatlant.training.conference.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author yevgen voronetski
 */
@RestController
public class ConferenceController {
    private final ConferenceService conferenceService;

    @Autowired
    public ConferenceController(ConferenceService conferenceService) {
        this.conferenceService = conferenceService;
    }

    @PostMapping("/conferences")
    public ResponseEntity<Conference> createConference(@RequestBody final Conference conference) {
        return ResponseEntity.ok(conferenceService.saveConference(conference));
    }

    @GetMapping("/conferences")
    public ResponseEntity<Iterable<Conference>> getAllConferences() {
        return ResponseEntity.ok(conferenceService.getAllConferences());
    }

    @PostMapping("/conferences/{conferenceId}/talks")
    public ResponseEntity<Talk> addTalk(@PathVariable final Long conferenceId, @RequestBody final Talk talk) {
        return ResponseEntity.ok(conferenceService.addTalk(conferenceId, talk));
    }

    @GetMapping("/conferences/{conferenceId}/talks")
    public ResponseEntity<Iterable<Talk>> getTalks(@PathVariable final Long conferenceId) {
        return ResponseEntity.ok(conferenceService.getAllTalksForConference(conferenceId));
    }

    @PutMapping("/conferences/{conferenceId}")
    public ResponseEntity<Conference> updateConference(@PathVariable final Long conferenceId, @RequestBody final Conference conference) {
        return ResponseEntity.ok(conferenceService.updateConference(conferenceId, conference));
    }
}
