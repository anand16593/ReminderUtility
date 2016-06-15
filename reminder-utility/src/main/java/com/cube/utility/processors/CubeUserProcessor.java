/*package com.cube.utility.processors;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import org.bson.types.ObjectId;
import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.cube.utility.beans.CitrusUserResponse;
import com.cube.utility.beans.ProfilebyEmail;
import com.cube.utility.entities.Consumer;
import com.cube.utility.redis.RedisConstants;
import com.cube.utility.redis.RedisDAO;
import com.cube.utility.repositories.ConsumerRepository;
import com.cube.utility.repositories.ReminderRepository;

@Component
public class CubeUserProcessor {

	private final ConsumerRepository consumerRepository;
	private final MongoReminderProcessor reminderProcessor;
	private final RedisDAO redisDAO;
	private final ReminderRepository reminderRepository;

	@Autowired
	public CubeUserProcessor(ConsumerRepository consumerRepository,
			RedisDAO redisDAO, MongoReminderProcessor reminderProcessor,
			ReminderRepository reminderRepository) {
		this.consumerRepository = consumerRepository;
		this.redisDAO = redisDAO;
		this.reminderProcessor = reminderProcessor;
		this.reminderRepository=reminderRepository;
	}

	@Async
	public void processUserData(ObjectId userId, String email,
			CitrusUserResponse userData) throws JSONException, IOException {

		Consumer consumer = null;
		if (isNewUser(email)) {
			if (userData != null
					&& userData.getResponseData() != null
					&& userData.getResponseData().getProfileByEmail()
							.getEmail() != null) {
				ProfilebyEmail userProfile = userData.getResponseData()
						.getProfileByEmail();

				if (userProfile.IsEmailVerified()
						&& userProfile.isMobileVerified()) {

					consumer = new Consumer(userProfile.getEmail(),
							userProfile.getMobile(), userProfile.getFirstName()
									+ " " + userProfile.getLastName());

				} else {
					redisDAO.hset(RedisConstants.USER_NOT_VERIFIED,
							RedisConstants.USER_NOT_VERIFIED + "_" + email,
							email);

					consumer = new Consumer(email, "", "");
				}
			} else {
				redisDAO.hset(RedisConstants.USER_DATA_NOT_FOUND,
						RedisConstants.USER_DATA_NOT_FOUND + "_" + email, email);
				consumer = new Consumer(email, "", "");
			}
		} else {
			redisDAO.hset(RedisConstants.USER_ALREADY_PRESENT,
					RedisConstants.USER_ALREADY_PRESENT + "_" + email, email);
			
			Consumer existingConsumer = consumerRepository.findByEmail(email);
			if(reminderRepository.findByConsumer(existingConsumer)==null)
			{
				reminderProcessor.getConsumerReminders(userId,existingConsumer );
			}
		}
		if (consumer != null) {
			consumer = consumerRepository.save(consumer);
			reminderProcessor.getConsumerReminders(userId, consumer);
		}

	}

	private boolean isNewUser(String email) {
		return consumerRepository.findByEmail(email.trim()) != null ? false
				: true;
	}

}
*/