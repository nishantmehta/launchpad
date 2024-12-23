package nishant.application.todo;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/api/todos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TodoResource {

    List<TodoEntry> todoEntries = new ArrayList<>();

    @GET
    public List<TodoEntry> getAllTodos() {
        return todoEntries;
    }

    @GET
    @Path("/{id}")
    public Optional<TodoEntry> getTodo(@PathParam("id") UUID id) {

        return todoEntries.stream().parallel().
                filter(entry -> entry.uuid().equals(id)).findAny();
    }

    @POST
    public Response createTodo(TodoEntry todo) {
        todoEntries.add(todo);
        return Response.status(201).entity(todo).build();
    }


    @DELETE
    @Path("/{id}")
    public Response deleteTodo(@PathParam("id") UUID id) {
        Optional<TodoEntry> todo = getTodo(id);
        todoEntries.removeIf(todoEntry -> todoEntry.uuid().equals(id));
        if (todo.isPresent()) return Response.noContent().build();
        return Response.status(404).build();
    }
}
