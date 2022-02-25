package com.udacity.lesson04.exercise04;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Application {

    public static void main(String[] args) {
        // STEP 1: Craft the URI to connect to your local MongoDB server
        // Host: localhost
        // Port: 27017 (default)
        // Username: course3
        // Password: course3
        // DB: jdnd-c3
        String uri = "mongodb://root:root@127.0.0.1:27017/jdnd-c3?authSource=admin";

        // STEP 2: Create a MongoClient
        try (MongoClient mongoClient = MongoClients.create(uri)) {

            // STEP 3: Select the jdnd-c3 database to work with
            MongoDatabase mongoDatabase = mongoClient.getDatabase("jdnd-c3");

            mongoDatabase.createCollection("tl_members");
            MongoCollection<Document> tl_members = mongoDatabase.getCollection("tl_members");

            Document tl_member = new Document()
                    .append("first_name", "Carl")
                    .append("last_name", "Jenkins")
                    .append("gender", "male")
                    .append("age", 23)
                    .append("address", new Document().append("street", "123 Main Street").append("city", "Oakland").append("state", "CA"))
                    .append("interests", "\"pilates\",\"swim\",\"crossfit\"")
                    .append("balance", 125.20);
            // Perform all the steps listed in the exercise

            tl_members.insertOne(tl_member);

            ObjectId objectId = tl_member.getObjectId("_id");

            tl_members.updateOne(new Document("_id", objectId),
                    new Document().append("$rename", new Document("gender", "sex")));
        }

        // IMPORTANT: Make sure to close the MongoClient at the end so your program exits.
    }
}
