package com.okta.jerseyrest.resource;

import com.okta.jerseyrest.model.Task;
import com.okta.jerseyrest.request.TaskRequest;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/tasks") 
@Singleton 
public class TaskResource {

    private Map<UUID, Task> tasks = new LinkedHashMap<>();

    @POST 
    @Consumes(MediaType.APPLICATION_JSON) 
    public String createTask(TaskRequest request) {
        UUID taskId = UUID.randomUUID();
        tasks.put(taskId, new Task(taskId, request.getDescription()));
        return taskId.toString();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }

    @PUT 
    @Path("/{taskId}") 
    public Response updateTask(@PathParam("taskId") UUID taskId, TaskRequest request) { 
        if (!tasks.containsKey(taskId)) {
            // return 404
            return Response.status(Response.Status.NOT_FOUND).build(); 
        }

        Task task = tasks.get(taskId);
        task.setDescription(request.getDescription());

        // return 204
        return Response.noContent().build();
    }

    @DELETE 
    @Path("/{taskId}")
    public Response deleteTask(@PathParam("taskId") UUID taskId) { 
        tasks.remove(taskId);
        return Response.noContent().build();
    }
}