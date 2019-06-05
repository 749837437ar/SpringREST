package com.validus.codingtest.musicdb.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.validus.codingtest.musicdb.domain.Song;
import com.validus.codingtest.musicdb.rest.exception.DataFormatException;
import com.validus.codingtest.musicdb.service.SongService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/song")
public class SongController {

	public SongController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SongService songService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String addCustomer(@RequestBody Song album, HttpServletRequest request, HttpServletResponse response) {
		Song savedSong = songService.save(album);
		response.setHeader("Location", request.getRequestURL().append("/").append(album.getAlbumId()).toString());
		return "SUCCESS";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Song> getAllSongs() {
		return songService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Song getSong(@PathVariable("id") int id,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Song song = this.songService.findOne(id);
		// checkResourceFound(csmtr);
		// todo: http://goo.gl/6iNAkz
		return song;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateSong(
			@ApiParam(value = "The ID of the existing hotel resource.", required = true) @PathVariable("id") int id,
			@RequestBody Song song, HttpServletRequest request, HttpServletResponse response) throws Exception {
		 //if (id != song.getId()) throw new DataFormatException("ID doesn't match!");
		this.songService.save(song);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("id") int id,
			HttpServletRequest request, HttpServletResponse response) {
		songService.delete(id);
	}

}
