package com.TripleT.MuteJig.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Role {
    @Id
    @Column(name = "name", nullable = false, unique = true)
    String name;

    @Column(name = "description")
    String description;
}