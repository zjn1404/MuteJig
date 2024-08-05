package com.TripleT.MuteJig.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity(name = "singer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Singer {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    String id;

    @Column(name = "name")
    String name;
}
