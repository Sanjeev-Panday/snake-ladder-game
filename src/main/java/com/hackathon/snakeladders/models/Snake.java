package com.hackathon.snakeladders.models;

public class Snake extends GameCharacter {
    public Snake(int start, int end) {
        super(CharacterType.SNAKE,start, end);
        if(start < end) {
            throw new IllegalArgumentException("Start should be greater than end for snake");
        }
    }
}
