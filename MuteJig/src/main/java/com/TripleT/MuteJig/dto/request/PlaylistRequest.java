package com.TripleT.MuteJig.dto.request;

import java.util.Set;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistRequest {

    String name;

    Set<String> songs;
}
