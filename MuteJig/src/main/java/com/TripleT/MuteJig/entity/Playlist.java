package com.TripleT.MuteJig.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity(name = "playlist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Playlist {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    String id;

    @Column(name = "name")
    String name;

}
