/*package com.cube.utility.processors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.bson.types.ObjectId;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cube.utility.beans.ReminderCollection;
import com.cube.utility.entities.Consumer;
import com.cube.utility.enums.ColleactionEnum;
import com.google.gson.Gson;

@Component
public class MongoReminderProcessor {

	private final Jongo mongoClient;
	private final MessageSource messageSource;
	private final CubeReminderProcessor cubeReminderProcessor;

	@Autowired
	public MongoReminderProcessor(Jongo mongoClient,
			MessageSource messageSource,
			CubeReminderProcessor cubeReminderProcessor) {
		this.mongoClient = mongoClient;
		this.messageSource = messageSource;
		this.cubeReminderProcessor = cubeReminderProcessor;
	}

	@Async
	public void getConsumerReminders(ObjectId userId, Consumer consumer)
			throws JSONException, IOException {

		MongoCollection reminderCollection = mongoClient
				.getCollection(ColleactionEnum.REMINDERS.getDisplayLabel());

		MongoCursor<Object> reminderCursor = reminderCollection.find(
				"{userId: #}", userId).as(Object.class);

		while (reminderCursor.hasNext()) {
			String reminderJson = new Gson().toJson(reminderCursor.next());
			ReminderCollection reminder = new Gson().fromJson(reminderJson,
					ReminderCollection.class);

			HttpHeaders headers = new HttpHeaders();
			try
			{
				headers.set("access-key", messageSource.getMessage(
						new StringBuilder(reminder.getAppCode().toLowerCase())
						.append(".access.key").toString(), null, Locale.US));
				
			}
			catch(Exception ex)
			{
				headers.set("access-key", "");
			}
			headers.setContentType(MediaType.APPLICATION_JSON);

			try {
				
				ResponseEntity<ArrayList> response = getResponse(reminder,headers);
				List<String> keys = response.getBody();
				JSONObject serviceData = new JSONObject();
				JSONObject reminderJSON = new JSONObject(reminderJson);
				for (String key : keys) {
						serviceData.append(key,reminderJSON.has(key)?
								reminderJSON.get(key):"");
				}
				cubeReminderProcessor.processReminders(consumer, reminder,
						serviceData);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		reminderCursor.close();
	}
	
	private synchronized static ResponseEntity<ArrayList> getResponse(ReminderCollection reminder, HttpHeaders headers){
		return  new RestTemplate()
		.exchange(
				"http://localhost:8081/v1/keys/"
						+ reminder.getServiceType() + "/"
						+ reminder.getCode(), HttpMethod.GET,
				new HttpEntity("", headers), ArrayList.class);
	}
}
*/