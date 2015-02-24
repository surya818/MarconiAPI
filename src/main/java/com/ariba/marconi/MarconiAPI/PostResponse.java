package com.ariba.marconi.MarconiAPI;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class PostResponse implements RESTPOST{

	public Object getPostResponseObject(String url,String data) {
		Client cli = Client.create();
		WebResource wr = cli.resource(url);
		ClientResponse resp = wr.post(ClientResponse.class,data);
		return resp;
	}

	

}
