package com.udacity.test;


import com.udacity.entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory(
                "person");
        EntityManager entityManager = managerFactory.createEntityManager();

        // persist
        entityManager.getTransaction().begin();
        Person person1 = new Person("Mario");
        Person person2 = new Person("John");
        Person person3 = new Person("Luke");
        Person person4 = new Person("Bob");
        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.persist(person4);
        entityManager.getTransaction().commit();

        // find
        Person personFind = entityManager.find(Person.class, 1L);
        System.out.println("Find: " + personFind.getName());

    }

}
