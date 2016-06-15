package com.cube.utility.repositories;

import org.springframework.stereotype.Repository;

import com.cube.utility.entities.Consumer;

@Repository
public interface ConsumerRepository extends
		BaseRepository<Consumer, Integer> {

	public Consumer findByEmail(String email);
	
}
