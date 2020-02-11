package com.okta.jerseyrest.model;

import java.util.UUID;

public class Task {

    private UUID id;
    private String description;

    public Task(UUID id, String description) {
        this.id = id;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}