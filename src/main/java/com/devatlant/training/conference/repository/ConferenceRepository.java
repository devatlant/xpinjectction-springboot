package com.devatlant.training.conference.repository;

import com.devatlant.training.conference.domain.Conference;
import org.springframework.data.repository.CrudRepository;

public interface ConferenceRepository extends CrudRepository<Conference, Long>{
}
