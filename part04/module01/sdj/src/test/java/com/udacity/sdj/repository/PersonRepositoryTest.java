package com.udacity.sdj.repository;

import com.udacity.sdj.entity.Person;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@DisplayName("Test for Person Repository")
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    @DisplayName("Injected components are not Null")
    void injectedComponentsAreNotNull() {
        Assertions.assertThat(personRepository).isNotNull();
    }

    @Test
    @DisplayName("List all people when Successful")
    void findAll_ListAllPerson_WhenSuccessful() {
        Iterable<Person> saveAll = this.personRepository.saveAll(
                List.of(new Person(1L, "Luan"), new Person(2L, "Mateuz"),
                        new Person(3L, "John"), new Person(4L, "Luke"),
                        new Person(5L, "Maria"))
        );

        Assertions.assertThat(saveAll)
                .isNotNull()
                .isNotEmpty()
                .hasSize(5)
                .containsAll(saveAll)
                .isInstanceOf(Iterable.class);
    }

    @Test
    @DisplayName("Save persists person when Successful")
    void save_PersistPerson_WhenSuccessful() {
        Person person = new Person("Luan");

        personRepository.save(person);

        Iterable<Person> all = personRepository.findAll();
        Assertions.assertThat(all).extracting(Person::getName).containsOnly("Luan");
    }

    @Test
    @DisplayName("Save updates person when Successful")
    void save_UpdatesPerson_WhenSuccessful() {
        Person personSaved = this.personRepository.save(new Person("Luan"));
        personSaved.setName("Mateuz");

        Person personUpdate = this.personRepository.save(personSaved);

        Assertions.assertThat(personUpdate.getName())
                .isNotNull()
                .isEqualTo(personSaved.getName());
    }

    @Test
    @DisplayName("Delete removes person when Successful")
    void delete_RemoverPerson_WhenSuccessful() {
        Person personSaved = this.personRepository.save(new Person(1L, "Luan"));

        this.personRepository.delete(personSaved);

        Optional<Person> byId = this.personRepository.findById(personSaved.getId());

        Assertions.assertThat(byId).isEmpty();
    }
}