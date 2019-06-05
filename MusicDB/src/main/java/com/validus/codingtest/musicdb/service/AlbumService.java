package com.validus.codingtest.musicdb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.validus.codingtest.musicdb.domain.Album;

public interface AlbumService extends JpaRepository<Album, Integer>{
}
