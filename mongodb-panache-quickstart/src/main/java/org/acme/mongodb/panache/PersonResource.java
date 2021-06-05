package org.acme.mongodb.panache;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

import static org.acme.mongodb.panache.Status.LIVING;

@Path("/persons")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    @Path("/count")
    public long count(){
        return personRepository.count();
    }

    @GET
    public List<Person> allPersons() {
        return personRepository.findAll().list();
    }

    @POST
    @Path("/Loics")
    public Person createLoics() {
        var person = new Person();
        person.name = "Loïc";
        person.birth = LocalDate.now().minusYears(25);
        person.status = LIVING;

        personRepository.persist(person);

        return person;
    }

    @DELETE
    @Path("/Loics")
    public Response deleteLoics() {
        personRepository.deleteLoics();

        return Response.noContent().build();
    }
}