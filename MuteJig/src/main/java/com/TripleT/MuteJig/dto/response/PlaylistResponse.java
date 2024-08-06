package com.TripleT.MuteJig.dto.response;

import com.TripleT.MuteJig.entity.Song;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistResponse {

    String id;

    String name;

    Set<Song> songs;

}
