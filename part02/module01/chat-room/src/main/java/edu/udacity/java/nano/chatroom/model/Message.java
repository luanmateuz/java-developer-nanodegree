package edu.udacity.java.nano.chatroom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String message;

    public enum Type{
        ENTER, SPEAK, LEAVE
    }
}
