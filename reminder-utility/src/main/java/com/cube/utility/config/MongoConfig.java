package com.cube.utility.config;

import java.net.UnknownHostException;

import org.jongo.Jongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	public String getDatabaseName() {
		return "citruscube";
	}

	@Override
	@Bean
	public Mongo mongo() throws UnknownHostException {
		return new MongoClient("52.11.17.185", 27017);
	}
	
	@Bean
	public Jongo jongo() throws UnknownHostException
	{
		DB db = mongo().getDB(getDatabaseName());
		char[] passwordChars=new char["pJs6LfHylw".length()];
		"pJs6LfHylw".getChars(0, "pJs6LfHylw".length(), passwordChars, 0);
		db.authenticate("app", passwordChars);
		return new Jongo(db);
	}

}