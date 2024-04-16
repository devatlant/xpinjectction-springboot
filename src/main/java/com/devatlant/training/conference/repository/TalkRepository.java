package com.devatlant.training.conference.repository;

import com.devatlant.training.conference.domain.Talk;
import org.springframework.data.repository.CrudRepository;

public interface TalkRepository extends CrudRepository<Talk, Long>{
}
