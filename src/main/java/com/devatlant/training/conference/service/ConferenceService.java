package com.devatlant.training.conference.service;

import com.devatlant.training.conference.domain.Talk;

public interface ConferenceService {
    Talk addTalk(Long conferenceId, Talk talk);
}
