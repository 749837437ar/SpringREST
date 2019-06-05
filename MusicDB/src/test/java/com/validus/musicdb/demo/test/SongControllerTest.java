package com.validus.musicdb.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.validus.codingtest.musicdb.domain.Song;

public class SongControllerTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createAlbum() throws Exception {
		String uri = "/song";
		Song song = new Song();
		song.setId((int) (Math.random() * 100));
		song.setAlbumId(3);
		;
		song.setTrack(2);
		song.setSongName("Pop Rock");

		String inputJson = super.mapToJson(song);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		System.out.println("******************status***************" + status);
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		// System.out.println("content::"+mvcResult.getResponse().getStatus());

		assertEquals(content, "SUCCESS");
	}

	@Test
	public void getSongList() throws Exception {
		String uri = "/song";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Song[] productlist = super.mapFromJson(content, Song[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void updateSongById() throws Exception {
		String uri = "/song/1";
		Song song = new Song();
		song.setSongName("Hey Ram");
		song.setAlbumId(3);
		String inputJson = super.mapToJson(song);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(204, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");

	}

	@Test
	public void deleteSongById() throws Exception {
		String uri = "/song/2";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(204, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");
	}

}
