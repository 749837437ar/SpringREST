package com.validus.codingtest.musicdb.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Artist")
public class Artist extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "artistCategory", fetch = FetchType.LAZY)
	private Set<Album> albumList = new HashSet<>();

	public Set<Album> getAlbumList() {
		return albumList;
	}

	public void setAlbumList(Set<Album> albumList) {
		this.albumList = albumList;
	}

	public Artist() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
