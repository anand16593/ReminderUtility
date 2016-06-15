/*package com.cube.utility.processors;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.cube.utility.beans.ReminderCollection;
import com.cube.utility.entities.Consumer;
import com.cube.utility.entities.Reminder;
import com.cube.utility.repositories.ReminderRepository;

@Component
public class CubeReminderProcessor {
	
	private final ReminderRepository reminderRepository;
	private final MongoDuesProcessor duesProcessor;
	
	@Autowired
	public CubeReminderProcessor(ReminderRepository reminderRepository,
			MongoDuesProcessor duesProcessor) {
		this.reminderRepository = reminderRepository;
		this.duesProcessor=duesProcessor;
	}
	

	@Async
	public void processReminders(Consumer consumer, ReminderCollection reminderCollection,
			JSONObject serviceData) throws ParseException, IOException {

		Reminder reminder = new Reminder(consumer,new Date(),
				reminderCollection.getActive().toString(),
				reminderCollection.getEnabled().toString(),
				reminderCollection.getCircleCode(),
				reminderCollection.getOperator(), reminderCollection.getCode(),
				reminderCollection.getOptionOneCode(),
				reminderCollection.getOptionTwoCode(),
				reminderCollection.getServiceType(),
				reminderCollection.getTitle(),
				reminderCollection.getCategory(), reminderCollection.getType(),
				reminderCollection.getRepeat(), reminderCollection.getOn(),
				reminderCollection.getPlan().toString(), reminderCollection.getPayment().toString(),
				reminderCollection.getAppCode(), serviceData.toString());
		
		reminder = reminderRepository.save(reminder);
		
		duesProcessor.process(reminderCollection.get_id(), reminder);

	}

}
*/