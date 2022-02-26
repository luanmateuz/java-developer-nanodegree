package com.udacity.lesson04.exercise13.repository;

import com.udacity.lesson04.exercise13.model.Member;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @DisplayName("Injected components are not Null")
    void injectedComponentsAreNotNull() {
        Assertions.assertThat(memberRepository).isNotNull();
    }

    @Test
    @DisplayName("save member in database")
    void save() {
        Member member = new Member("Luan", "Mateuz");
        Member save = this.memberRepository.save(member);

        Assertions.assertThat(save.getId()).isNotNull();

        Assertions.assertThat(save)
                .isNotNull()
                .isEqualTo(member)
                .isInstanceOf(Member.class);
    }

}