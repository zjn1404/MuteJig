package com.TripleT.MuteJig.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.sql.Date;

@Entity(name = "song")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Song {
    @Id
    @Column (name = "song", nullable = false, unique = true)
    String id;

    @Column (name = "poster_id", nullable = false)
    String posterId;

    @Column (name = "name",nullable = false)
    String name;

    @Column (name = "type",nullable = false)
    String type;

    @Column(name = "upload_date")
    Date uploadDate;
}
