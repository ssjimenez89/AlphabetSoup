package com.gym.appointments.Input;

import java.util.UUID;

public class AlphabetSoupInput extends JsonInput{
    UUID id;

    public AlphabetSoupInput() {
    }

    public AlphabetSoupInput(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
