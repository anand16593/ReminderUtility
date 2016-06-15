/*package com.cube.utility.processors;

import java.io.IOException;
import java.text.ParseException;

import org.bson.types.ObjectId;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.cube.utility.beans.DuesCollection;
import com.cube.utility.entities.Reminder;
import com.cube.utility.enums.ColleactionEnum;


@Component
public class MongoDuesProcessor {

	private final Jongo mongoClient;
	private final CubeDuesProcessor cubeDuesProcessor;

	@Autowired
	public MongoDuesProcessor(Jongo mongoClient,
			CubeDuesProcessor cubeDuesProcessor) {
		this.mongoClient = mongoClient;
		this.cubeDuesProcessor=cubeDuesProcessor;
	}
	
	@Async
	public void process(ObjectId reminderId,Reminder reminder) throws ParseException, IOException
	{
		
		MongoCollection duesCollection = mongoClient
				.getCollection(ColleactionEnum.DUES.getDisplayLabel());

		MongoCursor<DuesCollection> duesCursor = duesCollection.find(
				"{reminderId: #}", reminderId).as(DuesCollection.class);
		
		DuesCollection dues;
		while(duesCursor.hasNext())
		{
			try{
				
				dues = duesCursor.next();
				cubeDuesProcessor.processDues(dues, reminder);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		duesCursor.close();
	}
	
}
*/