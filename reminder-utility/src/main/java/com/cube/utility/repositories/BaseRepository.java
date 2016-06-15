package com.cube.utility.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@org.springframework.transaction.annotation.Transactional(value="baseTransactionManager")
public interface BaseRepository <T, ID extends Serializable> extends JpaRepository<T, ID> { 
	
}