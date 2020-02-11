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
}