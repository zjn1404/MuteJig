package com.TripleT.MuteJig.dto.response;

import com.TripleT.MuteJig.entity.Singer;
import com.TripleT.MuteJig.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.util.Set;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SongResponse {

    String id;

    String name;

    String type;

    Date uploadDate;

    User user;

    Set<Singer> singers;

}
