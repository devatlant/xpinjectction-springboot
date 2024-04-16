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
@NoArgsConstructor
public class Conference {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String theme;
    private LocalDate startDate;
    private LocalDate endDate;
    private int participantsCount;
    @OneToMany
    private Set<Talk> talks;

    public void addTalk(Talk talk) {
        if (this.talks == null) {
            throw new RuntimeException("Talks are not initialized");
        }
        talks.add(talk);
    }

    public void copyFromAnotherConference(final Conference another) {
        this.name = another.getName();
        this.theme = another.getTheme();
        this.startDate = another.getStartDate();
        this.endDate = another.getEndDate();
        this.participantsCount = another.getParticipantsCount();
        this.talks = another.getTalks();
    }
}
