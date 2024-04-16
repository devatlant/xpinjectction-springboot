package com.devatlant.training.conference.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/**
 * @author yevgen voronetski
 */
@Entity(name = "talk")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Talk {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private final Long id;
    private final String title;
    private final String description;
    private final String speakerName;
    private final TalkType type;
}
