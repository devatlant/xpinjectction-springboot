package com.devatlant.training.conference.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

import java.util.Set;

/**
 * @author yevgen voronetski
 */
@Entity(name = "conference")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Conference {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private final String name;
    private final String theme;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int participantsCount;
    @OneToMany
    private final Set<Talk> talks;

    public void addTalk(Talk talk) {
        if (this.talks == null) {
            throw new RuntimeException("Talks are not initialized");
        }
        talks.add(talk);
    }
}
