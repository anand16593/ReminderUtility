/*package com.cube.utility.processors;

import java.util.Arrays;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cube.utility.beans.CitrusUserRequestBean;
import com.cube.utility.beans.CitrusUserResponse;
import com.google.gson.Gson;

@Component
public class CitrusUserDataProcessor {

	private final static String ACCESS_TOKEN = "Bearer f7788481-403e-4037-a6c0-2beb1cee1571";
	private final CubeUserProcessor cubeUserProcessor;
	
	@Autowired
	public CitrusUserDataProcessor(CubeUserProcessor cubeUserProcessor) {
		this.cubeUserProcessor = cubeUserProcessor;
	}
	
	@Async
	public void getUserData(ObjectId userId, String email) {
		try {
			HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
			factory.setConnectTimeout(60000);

			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", ACCESS_TOKEN);
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			CitrusUserRequestBean request = new CitrusUserRequestBean();
			request.setEmail(email);
			RestTemplate restTemplate = new RestTemplate(factory);

			ResponseEntity<CitrusUserResponse> response = restTemplate
					.exchange(
							"https://admin.citruspay.com/service/um/profile/memberInfo",
							HttpMethod.POST,
							new HttpEntity(new Gson().toJson(request), headers),
							CitrusUserResponse.class);
			
			CitrusUserResponse userResponse = response.getBody();
			
			cubeUserProcessor.processUserData(userId,email,userResponse);
			
		} catch (Exception e) {
				getUserData(userId,email);
		}
	}

}
*/