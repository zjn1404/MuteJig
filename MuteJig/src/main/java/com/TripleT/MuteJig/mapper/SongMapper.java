package com.TripleT.MuteJig.mapper;

import com.TripleT.MuteJig.dto.request.song.SongCreationRequest;
import com.TripleT.MuteJig.dto.request.song.SongUpdateRequest;
import com.TripleT.MuteJig.dto.response.SongResponse;
import com.TripleT.MuteJig.entity.Singer;
import com.TripleT.MuteJig.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SongMapper {
    @Mapping(target = "singers", ignore = true)
    @Mapping(target = "user", ignore = true)
    Song toSong(SongCreationRequest songCreationRequest);

    @Mapping(target = "singers", ignore = true)
    void updateSong(@MappingTarget Song song, SongUpdateRequest songUpdateRequest);

    SongResponse toSongResponse(Song song);
}
