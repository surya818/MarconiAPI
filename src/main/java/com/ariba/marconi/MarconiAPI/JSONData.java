/*
 * This class has functionality that transforms 
 * JSON Response Object to Java COllection objects 
 * like Maps(for Response objects) and List<Map>(for collections)
 * 
 */

package com.ariba.marconi.MarconiAPI;

import java.awt.Container;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.container.ContainerFactory;

public class JSONData {
	
	
	public Map transfromJSONAsMap(Object resp) throws IOException, ParseException{
		ClientResponse cr = (ClientResponse) resp;
		InputStream stream = cr.getEntityInputStream();
		org.json.simple.parser.ContainerFactory cf = new org.json.simple.parser.ContainerFactory() {
			public Map createObjectContainer() {
				// TODO Auto-generated method stub
				return new HashMap();
			}
			
			public List creatArrayContainer() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		JSONParser parser = new JSONParser();
		HashMap outMap = (HashMap) parser.parse(new InputStreamReader(stream), cf);
		return outMap;
		
	}
	
	
	public List<Map> transfromJSONACollectionAsList(Object resp) throws IOException, ParseException{
		ClientResponse cr = (ClientResponse) resp;
		InputStream stream = cr.getEntityInputStream();
		org.json.simple.parser.ContainerFactory cf = new org.json.simple.parser.ContainerFactory() {
			
			public Map createObjectContainer() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public List creatArrayContainer() {
				// TODO Auto-generated method stub
				return new ArrayList<Map>();
			}
		};
		JSONParser parser = new JSONParser();
		ArrayList<Map> outList = (ArrayList<Map>) parser.parse(new InputStreamReader(stream), cf);
		return outList;
		
	}

}
