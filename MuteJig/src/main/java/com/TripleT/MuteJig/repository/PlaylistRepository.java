package com.TripleT.MuteJig.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TripleT.MuteJig.entity.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, String> {}
