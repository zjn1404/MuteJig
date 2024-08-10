package com.TripleT.MuteJig.dto.request.song;

import java.sql.Date;
import java.util.Set;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SongCreationRequest {

    String name;

    String type;

    Date uploadDate;

    String user;

    Set<String> singers;
}
