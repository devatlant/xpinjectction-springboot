package com.devatlant.training.conference.service;

import com.devatlant.training.conference.domain.Conference;
import com.devatlant.training.conference.domain.Talk;
import com.devatlant.training.conference.repository.ConferenceRepository;
import com.devatlant.training.conference.repository.TalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yevgen voronetski
 */
@Service
public class DefaultConferenceService implements ConferenceService{
    private final ConferenceRepository conferenceRepository;
    private final TalkRepository talkRepository;

    @Autowired
    public DefaultConferenceService(ConferenceRepository conferenceRepository, TalkRepository talkRepository) {
        this.conferenceRepository = conferenceRepository;
        this.talkRepository = talkRepository;
    }

    @Override
    public Iterable<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    @Override
    public Talk addTalk(Long conferenceId, Talk talk) {
        final var conf = conferenceRepository.findById(conferenceId)
            .orElseThrow(()-> new RuntimeException(String.format("Conference with id %s not found", conferenceId)));
        conf.addTalk(talk);
        final var saved = talkRepository.save(talk);
        conferenceRepository.save(conf);
        return saved;
    }

    @Override
    public Conference saveConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    @Override
    public Iterable<Talk> getAllTalksForConference(Long conferenceId) {
        return conferenceRepository.findById(conferenceId)
            .map(Conference::getTalks)
            .orElseThrow(()-> new RuntimeException(String.format("Conference with id %s not found", conferenceId)));
    }

    @Override
    public Conference updateConference(long conferenceId, Conference conference) {
        final var conf = conferenceRepository.findById(conferenceId)
            .orElseThrow(()-> new RuntimeException(String.format("Conference with id %s not found", conferenceId)));
        conf.copyFromAnotherConference(conference);
        return conferenceRepository.save(conf);
    }
}
