package com.devatlant.training.conference.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import java.time.LocalDate;

/**
 * @author yevgen voronetski
 */
@Entity(name = "conference")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Data
public class Conference {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private final String name;
    private final String theme;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int participantsCount;

}
