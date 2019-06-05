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

import com.validus.codingtest.musicdb.domain.Artist;
import com.validus.codingtest.musicdb.service.ArtistService;

@RestController
@RequestMapping(value = "/artist")
public class ArtistController extends AbstractRestHandler {

	@Autowired
	private ArtistService artistService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public String addArtist(@RequestBody Artist artist, HttpServletRequest request, HttpServletResponse response) {
		Artist savedArtist = artistService.save(artist);
		response.setHeader("Location", request.getRequestURL().append("/").append(artist.getId()).toString());
		return "SUCCESS";
	}

	@RequestMapping(value = "", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Artist> getAllArtist() {
		return artistService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Artist getArtist(@PathVariable("id") int id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Artist artist = this.artistService.findOne(id);
		return artist;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateArtist(@PathVariable("id") int id, @RequestBody Artist artist, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// if (id != customer.getId()) throw new DataFormatException("ID doesn't
		// match!");
		this.artistService.save(artist);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteArtist(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
		artistService.delete(id);
	}

}
