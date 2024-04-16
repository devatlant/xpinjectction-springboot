package com.devatlant.training.conference.service;

import com.devatlant.training.conference.domain.Conference;
import com.devatlant.training.conference.domain.Talk;


public interface ConferenceService {
    Iterable<Conference> getAllConferences();
    Talk addTalk(Long conferenceId, Talk talk);

    Conference saveConference(Conference conference);

    Iterable<Talk> getAllTalksForConference(Long conferenceId);

    Conference updateConference(long conferenceId, Conference conference);
}
