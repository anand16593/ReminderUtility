package com.cube.utility.processors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


@Service
public class CubeUMDataProcessor {

	public static String geOAuthToken(String email) throws RestClientException, URISyntaxException, UnirestException, JSONException
	{
		HttpResponse<String> response = Unirest.post("https://api.bankoncube.com/v1/api/oauth/token")
				  .header("authorization", "Basic cmVtaW5kZXJfc2VydmVyOnJlbWluZGVyX3NlcnZlciMyNik=")
				  .header("cache-control", "no-cache")
				  .header("postman-token", "65695f53-f0da-d4a9-ba73-31f981e53878")
				  .header("content-type", "application/x-www-form-urlencoded")
				  .body("grant_type=username&identifier="+email)
				  .asString();
		
		JSONObject res =  new JSONObject(response.getBody());
		if(res.has("access_token"))
		{
			return res.getString("access_token");
		}
		else
		{
			return null;
		}
		
	}
	
	public String getUserUUID(String email) throws JSONException, RestClientException, URISyntaxException, UnirestException
	{
			HttpResponse<String> response = Unirest.get("https://api.bankoncube.com/v1/reminder/user?email="+email)
					  .asString();
			
			JSONObject res =  new JSONObject(response.getBody());
			if(res.has("uuid"))
			{
				return res.getString("uuid");
			}
			else
			{
				return null;
			}
			
	}
	
	public static void  writeToFile(String email)
	{
		try {

			  String filename= "C:\\UM\\not-verified.txt";
			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
			    fw.write(email+"\n");//appends the string to the file
			    fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
