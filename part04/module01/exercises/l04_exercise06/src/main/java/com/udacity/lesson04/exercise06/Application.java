package com.udacity.lesson04.exercise06;

import com.mongodb.client.*;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

public class Application {

    public static void main(String[] args) {
        // STEP 1: Craft the URI to connect to your local MongoDB server
        // Host: localhost
        // Port: 27017 (default)
        // Username: course3
        // Password: course3
        // DB: jdnd-c3
        String uri = "mongodb://root:root@localhost:27017/jdnd-c3?authSource=admin";

        // STEP 2: Create a MongoClient
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // STEP 3: Select the jdnd-c3 database to work with
            MongoDatabase database = mongoClient.getDatabase("jdnd-c3");
            MongoCollection<Document> tl_members = database.getCollection("tl_members");

            // Perform all the steps listed in the exercise

            tl_members.find(new Document("last_name", "Khan"))
                    .iterator()
                    .forEachRemaining(System.out::println);

            tl_members.find(new Document(Map.of("last_name", "Doe", "gender", "female")))
                    .iterator().forEachRemaining(System.out::println);

            tl_members.find(new Document("interests", "golf"))
                    .iterator().forEachRemaining(p -> System.out.println(p.get("first_name")));

            Bson query = eq("gender", "male");

            System.out.println(tl_members.countDocuments(query));

            Document first = tl_members.find(new Document("gender", "female"))
                    .sort(new Document("first_name", 1))
                    .first();
            System.out.println(first);
        }

        // IMPORTANT: Make sure to close the MongoClient at the end so your program exits.
    }
}
