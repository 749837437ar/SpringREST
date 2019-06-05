package com.validus.codingtest.musicdb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.validus.codingtest.musicdb.domain.Artist;

public interface ArtistService extends JpaRepository<Artist, Integer>{
}

