package com.cube.utility.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cube.utility.entities.Consumer;
import com.cube.utility.entities.Reminder;

@Repository
public interface ReminderRepository extends
		BaseRepository<Reminder, Integer> {
	
	public List<Reminder> findByConsumer(Consumer consumer);

}
