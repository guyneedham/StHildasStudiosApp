package com.bgcompute.StHildasStudios.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectionSettingsTest {

	@Test
	public void testReaderGetsDetails() {
		ConnectionSettings reader = new ConnectionSettings();
		String url = reader.getServ();
		String name = reader.getName();
		String pass = reader.getPass();
		assertEquals(true, url.equals("jdbc:mysql://localhost/sthildas?"));
		assertEquals(true, name.equals("dev"));
		assertEquals(true, pass.equals("dev"));
	}

}
