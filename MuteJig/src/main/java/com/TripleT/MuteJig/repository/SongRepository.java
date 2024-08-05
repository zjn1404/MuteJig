package com.TripleT.MuteJig.repository;

import com.TripleT.MuteJig.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {

}
