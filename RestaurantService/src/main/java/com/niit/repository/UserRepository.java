package com.niit.repository;

import com.niit.domain.Image;
import com.niit.domain.Restaurant;
import com.niit.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    @Query("{'image.name': {$in:[?0]}}")
    Optional<Image> findByName(String name);
}
