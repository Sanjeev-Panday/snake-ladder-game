package com.hackathon.snakeladders.models;

public class Ladder extends GameCharacter {
    public Ladder(int start, int end) {
        super(CharacterType.LADDER,start,end);
        if(end < start) {
            throw new IllegalArgumentException("End can not be smaller than start for ladder");
        }
    }
}
