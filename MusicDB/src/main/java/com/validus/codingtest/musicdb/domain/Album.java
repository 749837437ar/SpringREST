package com.validus.codingtest.musicdb.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Album")
public class Album extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "artist_id")
	private int artistId;

	@Column(name = "name")
	private String name;

	@Column(name = "year_released")
	private int relesed;

	@ManyToOne
	@JoinColumn(name = "artist_id", insertable = false, updatable = false)
	@JsonIgnore
	private Artist artistCategory;

	@OneToMany(mappedBy = "albumCategory", fetch = FetchType.LAZY)
	private Set<Song> songSet = new HashSet<>();

	public Album() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRelesed() {
		return relesed;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public void setRelesed(int relesed) {
		this.relesed = relesed;
	}

	public Artist getArtistCategory() {
		return artistCategory;
	}

	public void setArtistCategory(Artist artistCategory) {
		this.artistCategory = artistCategory;
	}

	public Set<Song> getSongSet() {
		return songSet;
	}

	public void setSongSet(Set<Song> songSet) {
		this.songSet = songSet;
	}

}
