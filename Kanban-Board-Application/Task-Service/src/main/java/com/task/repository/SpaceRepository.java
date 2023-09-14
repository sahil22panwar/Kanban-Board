package com.task.repository;

import com.task.model.Space;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceRepository extends MongoRepository<Space,String> {
    Space findByEmail(String email);
    Space findBySpaceName(String spaceName);
    Space findBySpaceNameAndEmail(String spaceName,String email);
}