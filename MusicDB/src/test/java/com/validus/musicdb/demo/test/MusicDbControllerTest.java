package com.validus.musicdb.demo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.validus.codingtest.musicdb.domain.Album;

public class MusicDbControllerTest extends AbstractTest {
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void createAlbum() throws Exception {
		String uri = "/album";
		Album album = new Album();
		album.setId((int) (Math.random() * 100)); //
		album.setArtistId(2);
		;
		album.setName("Rio Pop");
		album.setRelesed(1999);

		String inputJson = super.mapToJson(album);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		System.out.println("******************status***************" + status);
		assertEquals(201, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "SUCCESS");
	}

	@Test
	public void getAlbumList() throws Exception {
		String uri = "/album";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Album[] productlist = super.mapFromJson(content, Album[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void updateAlbumById() throws Exception {
		String uri = "/album/1";
		Album album = new Album();
		album.setName("Apple");
		album.setArtistId(1);
		String inputJson = super.mapToJson(album);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.put(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(204, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");

	}

	@Test
	public void deleteAlbum() throws Exception {
		String uri = "/album/4";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(204, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(content, "");
	}

}