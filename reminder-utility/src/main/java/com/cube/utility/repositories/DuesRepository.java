package com.cube.utility.repositories;

import org.springframework.stereotype.Repository;

import com.cube.utility.entities.Dues;

@Repository
public interface DuesRepository extends
		BaseRepository<Dues, Integer> {

}
