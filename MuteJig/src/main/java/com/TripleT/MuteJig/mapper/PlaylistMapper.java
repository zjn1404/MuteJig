package com.TripleT.MuteJig.mapper;


import com.TripleT.MuteJig.dto.request.PlaylistRequest;
import com.TripleT.MuteJig.dto.response.PlaylistResponse;
import com.TripleT.MuteJig.entity.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PlaylistMapper {
    @Mapping(target = "songs", ignore = true)
    Playlist toPlaylist(PlaylistRequest playlistRequest);

    @Mapping(target = "songs", ignore = true)
    void updatePlaylist(@MappingTarget Playlist playlist, PlaylistRequest playlistRequest);

    PlaylistResponse toPlaylistResponse(Playlist playlist);
}
