package com.TripleT.MuteJig.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.FieldNameConstants;

import java.sql.Date;
import java.util.Set;

@Entity(name = "song")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Song {
    @Id
    @Column (name = "id", nullable = false, unique = true)
    String id;

    @Column (name = "poster_id", nullable = false)
    String posterId;

    @Column (name = "name",nullable = false)
    String name;

    @Column (name = "type",nullable = false)
    String type;

    @Column(name = "upload_date")
    Date uploadDate;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.DETACH
            }
    )
    @JoinTable(
            name = "playlist_song",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = {@JoinColumn(name = "playlist_id")}
    )
    Set<Playlist> playlists;


    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.DETACH
            }
    )
    @JoinTable(
            name = "song_singer",
            joinColumns = {@JoinColumn(name = "song_id")},
            inverseJoinColumns = {@JoinColumn(name = "singer_id")}
    )
    Set<Singer> singers;
}
