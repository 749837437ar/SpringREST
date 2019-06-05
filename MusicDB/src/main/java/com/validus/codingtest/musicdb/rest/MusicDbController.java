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

import com.validus.codingtest.musicdb.domain.Album;
import com.validus.codingtest.musicdb.service.AlbumService;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/album")
public class MusicDbController extends AbstractRestHandler {

	@Autowired
	private AlbumService albumService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(HttpStatus.CREATED)
	public String addCustomer(@RequestBody Album album, HttpServletRequest request, HttpServletResponse response) {
		Album savedCustomer = albumService.save(album);
		response.setHeader("Location", request.getRequestURL().append("/").append(album.getId()).toString());
		return "SUCCESS";
	}

	@RequestMapping(value = "", method = RequestMethod.GET, consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Album> getAllCustomer() {
		return albumService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET ,consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Album getAlbum(
			@ApiParam(value = "The ID of the customer.", required = true) @PathVariable("id") int id,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Album cstmr = this.albumService.findOne(id);
		// checkResourceFound(csmtr);
		// todo: http://goo.gl/6iNAkz
		return cstmr;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT ,consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateArtist(@PathVariable("id") int id, @RequestBody Album album, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// if (id != customer.getId()) throw new DataFormatException("ID doesn't
		// match!");
		this.albumService.save(album);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, consumes = {"application/json"}, produces = {"application/json"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteArtist(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
		albumService.delete(id);
	}

}
