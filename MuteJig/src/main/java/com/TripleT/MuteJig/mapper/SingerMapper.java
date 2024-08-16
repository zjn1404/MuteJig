package com.TripleT.MuteJig.mapper;

import com.TripleT.MuteJig.dto.request.SingerRequest;
import com.TripleT.MuteJig.dto.response.SingerResponse;
import com.TripleT.MuteJig.entity.Singer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
        //, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface SingerMapper {

    Singer toSinger(SingerRequest singerRequest);
    SingerResponse toSingerResponse(Singer singer);
    
}
