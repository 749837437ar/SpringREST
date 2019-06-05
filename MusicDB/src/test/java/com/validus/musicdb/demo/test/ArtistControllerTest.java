package com.validus.musicdb.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.validus.codingtest.musicdb.domain.Artist;

public class ArtistControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getArtistList() throws Exception {
		String uri = "/artist";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Artist[] productlist = super.mapFromJson(content, Artist[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void createArtist() throws Exception {
		String uri = "/artist";
		Artist artist = new Artist();
		artist.setId(4);
		artist.setName("Jackson");
		String inputJson = super.mapToJson(artist);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "SUCCESS");
	}

	@Test
	public void updateArtistById() throws Exception {
		String uri = "/artist/1";
		Artist art = new Artist();
		art.setName("Apple");
		String inputJson = super.mapToJson(art);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(204, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");

	}

	@Test
	public void deleteArtist() throws Exception {
		String uri = "/artist/3";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(204, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");
	}

}
