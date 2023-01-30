package com.niit.repository;

import com.niit.domain.CheckOutDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CheckOutRepository extends MongoRepository<CheckOutDetails, Integer> {
}
