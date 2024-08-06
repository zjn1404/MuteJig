package com.TripleT.MuteJig.dto.request.song;

import com.TripleT.MuteJig.entity.Singer;
import com.TripleT.MuteJig.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.Set;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SongUpdateRequest {

    String name;

    String type;

    Date uploadDate;

    User user;

    Set<Singer> singers;

}
