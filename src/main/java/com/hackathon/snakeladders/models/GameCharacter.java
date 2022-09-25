package com.hackathon.snakeladders.models;

public abstract class GameCharacter {
    protected int start;
    protected int end;

    private CharacterType type;
    public GameCharacter(CharacterType type, int start, int end) {
        if(start == end) {
            throw new IllegalArgumentException("Start and End for a character can not be same");
        }
        this.start = start;
        this.end = end;
        this.type = type;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public CharacterType getType() {
        return type;
    }
}
