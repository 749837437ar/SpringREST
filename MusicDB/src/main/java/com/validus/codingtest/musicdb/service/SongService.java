package com.validus.codingtest.musicdb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.validus.codingtest.musicdb.domain.Song;

public interface SongService extends JpaRepository<Song, Integer>{

}
