/*
 * This class has the functionality that
 * validates JSON data from single JSON objects
 */
package com.ariba.marconi.MarconiAPI;

import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

public class JSONSingleObjectData {

	public boolean attributeExists(Object JSONobject,String attributeName) throws IOException, ParseException{
		JSONData data = new JSONData();
		HashMap objectmap = (HashMap) data.transfromJSONAsMap(JSONobject);
		return objectmap.containsKey(attributeName);
		
	}
	
	public Object getAttributeValue(Object JSONobject,String attributeName) throws IOException, ParseException{
		JSONData data = new JSONData();
		HashMap objectmap = (HashMap) data.transfromJSONAsMap(JSONobject);
		return objectmap.get(attributeName);
		
	}

}
