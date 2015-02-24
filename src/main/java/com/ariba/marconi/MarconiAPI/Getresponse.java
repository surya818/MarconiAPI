package com.ariba.marconi.MarconiAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.ws.rs.core.MultivaluedMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.container.ContainerFactory;

public class Getresponse implements RESTGET{
	public static void main(String[] args) throws IOException, ParseException{
		Getresponse gr = new Getresponse();
		//ClientResponse resps = (ClientResponse)gr.getResponseObject("https://www.googleapis.com/youtube/v3/videos?id=Hp5ZYAv9OVs&key=AIzaSyDdlrxHDUMAHPZM0M2YRLmLNHbl37TPeqc");
		//System.out.println(resps.toString());
		//System.out.println(gr.jsonEntries(resp, "Actors"));
		Map<String,String> map = new HashMap<String,String>();
		map.put("X-Ariba-Authorization", "Bearer e77d0020-e3af-413f-a2c7-e37e1720cfd3");
		map.put("Content-Type", "application/json");
		map.put("Accept", "application/json");
		map.put("Authorization","Bearer e77d0020-e3af-413f-a2c7-e37e1720cfd3");
		ClientResponse resp = (ClientResponse)gr.getResponseObject("https://svcrelss.ariba.com/v1/odata.svc/RecentsCollection",map);
		Client cli = Client.create();
		WebResource wr = cli.resource("https://svcrelss.ariba.com/v1/odata.svc/ToDosCollection");
		
		WebResource.Builder br = wr.header("Authorization", "Bearer f7c9befd-06ad-4507-b61a-80c420ceee33").header("Accept", "application/json");
		ClientResponse k=br.get(ClientResponse.class);
		System.out.println(k.getStatus());
		System.out.println(k.getEntity(String.class));
		
	}


	public Object getResponseObject(String url) {
		Client cli = Client.create();
		WebResource wr = cli.resource(url);
		ClientResponse resp = wr.get(ClientResponse.class);
		return resp;
	}
	
	public Object getResponseObject(String url,String HeaderName,String HeaderValue) {
		Client cli = Client.create();
		WebResource wr = cli.resource(url);
		ClientResponse resp = wr.header(HeaderName, HeaderValue).get(ClientResponse.class);
		return resp;
	}
	public Object getResponseObject(String url,Map<String, String> headers) {
		Client cli = Client.create();
		WebResource wr = cli.resource(url);
		Set<Entry<String, String>> set = headers.entrySet();
		Iterator<Entry<String, String>> it = set.iterator();
		while(it.hasNext()){
			Entry<String,String> entry = it.next();
			wr.header(entry.getKey(), entry.getValue());
		}
		ClientResponse resp = wr.get(ClientResponse.class);
		
		
		return resp;
	}

	
	
}
