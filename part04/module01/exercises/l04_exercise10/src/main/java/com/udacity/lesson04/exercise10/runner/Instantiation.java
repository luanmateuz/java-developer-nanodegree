package com.udacity.lesson04.exercise10.runner;

import com.udacity.lesson04.exercise10.model.Member;
import com.udacity.lesson04.exercise10.repository.MemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void run(String... args) throws Exception {
        // STEP 1: Define Member and MemberRepository first before changing this class

        // STEP 2: create a Member record
        Member member = new Member("Luan", "Mateuz");

        // STEP 3: save the Member record
        this.memberRepository.save(member);

        // read the Member using member last name
        List<Member> lastName = this.memberRepository.findByLastName("Mateuz");
        lastName.forEach(System.out::println);

    }
}
