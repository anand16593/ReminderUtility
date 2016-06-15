package com.cube.utility.processors;

import java.io.IOException;

import org.codehaus.jettison.json.JSONException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;
import org.springframework.stereotype.Component;

import com.cube.utility.beans.UserCollection;
import com.cube.utility.enums.ColleactionEnum;

@Component
public class MongoUserProcessor implements Runnable{

	private   Jongo mongoClient;
	private   CubeUMDataProcessor cubeUMDataProcessor;
	private Integer skip;
	
	public MongoUserProcessor() {
	}

	public MongoUserProcessor(Jongo mongoClient,CubeUMDataProcessor cubeUMDataProcessor,int skip) {
		this.skip = skip;
		this.mongoClient=mongoClient;
		this.cubeUMDataProcessor=cubeUMDataProcessor;
	}

	public void getReminderServerUsers() throws IOException, JSONException {}

	@Override
	public void run() {
		int count = 0;

		try{
			MongoCollection userCollection = mongoClient
					.getCollection(ColleactionEnum.USERS.getDisplayLabel());
			
			System.out.println(Thread.currentThread().getName()+" skipping "+(501679+(skip*1000))+ " records.");
			MongoCursor<UserCollection> userCursor = userCollection.find().skip(501679+(skip*1000)).limit(1000).as(
					UserCollection.class);
			while (userCursor.hasNext()) {

				UserCollection user = userCursor.next();
					if(user.getCube_uuid()==null || user.getCube_uuid()=="")
					{
						String uuid = cubeUMDataProcessor.getUserUUID(user.getEmail());
						if(uuid!=null && uuid!="")
						{
							count++;
							user.setCube_uuid(uuid);
							userCollection.update("{email:'"+user.getEmail()+"'}").with(user);
						}
					}
					
			}
			System.out.println(count);
			userCursor.close();
		}
		catch(Exception ex)
		{
			System.out.println(count);
			ex.printStackTrace();
		}
		
	
		
	}
}
