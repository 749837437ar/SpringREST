package com.validus.codingtest.musicdb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Song")
public class Song extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Song() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "album_id")
	private int albumId;

	@Column(name = "name")
	private String songName;

	@Column(name = "track")
	private int track;

	@ManyToOne
	@JoinColumn(name = "album_id", insertable = false, updatable = false)
	@JsonIgnore
	private Album albumCategory;

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public Album getAlbumCategory() {
		return albumCategory;
	}

	public void setAlbumCategory(Album albumCategory) {
		this.albumCategory = albumCategory;
	}

}
