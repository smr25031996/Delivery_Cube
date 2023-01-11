package com.niit.repository;

import com.niit.domain.Favorite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends MongoRepository<Favorite,String> {
    Favorite findByEmail(String email);
}
