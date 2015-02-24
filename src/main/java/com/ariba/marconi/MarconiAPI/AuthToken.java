package com.ariba.marconi.MarconiAPI;

import java.util.UUID;

import org.json.simple.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AuthToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthToken at = new AuthToken();
		ClientResponse obj = (ClientResponse) at.createAuthTokenResponse("https://svcdev10ss.ariba.com", "arooney", "p2pTeSg-11");
		System.out.println(obj.getEntity(String.class));

	}
	public static long getTOUTime(){
		return  System.currentTimeMillis();
	}
	public Object createAuthTokenResponse(String serviceUrl, String username,String realm){
		JSONObject data = new JSONObject();
		data.put("userName", username);
		data.put("localeID", ":");
		data.put("variantName", ":");
		data.put("passwordAdapter", "PasswordAdapter1");
		data.put("realm",realm);
		data.put("organization","default:Change Org");
		data.put("displayName","default:Change Name");
		data.put("email","default:Change Email");
		data.put("acceptedTOUVersion",2);
		data.put("acceptedTOUDate",getTOUTime());
		System.out.println(data.toJSONString());
		Client client = Client.create();
		WebResource resource = client.resource(serviceUrl+"/v1/oauth/device/code?scope=read");
		String randToken = UUID.randomUUID().toString();
		//ClientResponse response = resource.header("X-Ariba-Authorization","Bearer "+randToken).header("Authorization","Bearer "+randToken).post(ClientResponse.class,data.toJSONString());
		ClientResponse response = resource.get(ClientResponse.class);
		return response;
	}

}
