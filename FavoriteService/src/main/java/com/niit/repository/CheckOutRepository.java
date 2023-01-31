package com.niit.repository;

import com.niit.domain.CheckOutDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CheckOutRepository extends MongoRepository<CheckOutDetails, Integer> {
    @Query("{'user.email': {$in:[?0]}}")
    List<CheckOutDetails> findAllCheckOutDetailsEmail(String email);


}
