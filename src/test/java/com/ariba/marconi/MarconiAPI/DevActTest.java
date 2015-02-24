package com.ariba.marconi.MarconiAPI;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

import com.ariba.marconi.MarconiAPI.Getresponse;
import com.ariba.marconi.MarconiAPI.JSONData;

public class DevActTest {
	
	Getresponse resp;

	@Before
	public void setUp() throws Exception {
		 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException, ParseException {
		Getresponse gr = new Getresponse();
		ClientResponse cr = (ClientResponse) gr.getResponseObject("https://svcdev10ss.ariba.com/v1/api/requisitions?category=todos", "Authorization", "Bearer "+"aa763a94-b00b-44c0-8c80-781f595fce45");
		System.out.println(cr.getStatus());
		System.out.println(cr.toString());
	}

}
