package com.udacity.lesson04.exercise10.repository;

import com.udacity.lesson04.exercise10.model.Member;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {

    List<Member> findByLastName(String lastname);
}
