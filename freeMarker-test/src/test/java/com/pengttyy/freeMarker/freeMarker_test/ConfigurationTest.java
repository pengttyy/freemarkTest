package com.pengttyy.freeMarker.freeMarker_test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import freemarker.template.Configuration;

public class ConfigurationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Configuration singleInstance = SingleConfiguration.getInstance();
		assertNotNull(singleInstance);
	}
	
	

}
