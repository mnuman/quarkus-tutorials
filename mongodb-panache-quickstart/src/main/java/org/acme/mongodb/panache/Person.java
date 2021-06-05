package org.acme.mongodb.panache;

import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@MongoEntity(collection="ThePerson")
public class Person  {

    public ObjectId id; // used by MongoDB for the _id field
    public String name;
    public LocalDate birth;
    public Status status;
}
