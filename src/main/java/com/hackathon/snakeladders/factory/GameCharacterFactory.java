package com.hackathon.snakeladders.factory;

import com.hackathon.snakeladders.models.CharacterType;
import com.hackathon.snakeladders.models.GameCharacter;
import com.hackathon.snakeladders.models.Ladder;
import com.hackathon.snakeladders.models.Snake;

import java.util.Random;

public class GameCharacterFactory {

    private int boardSize;
    private Random random;
    public GameCharacterFactory(int boardSize) {
        this.boardSize = boardSize;
        random = new Random();
    }

    public static Snake createSnake(int start, int end) {
        return new Snake(start,end);
    }

    public static Snake createLadder(int start, int end) {
        return new Snake(start,end);
    }
    public GameCharacter createCharacter(CharacterType characterType) {
        int start;
        int end;
        int row;
        int nextRow;
        switch (characterType) {
            case SNAKE:
                start = random.nextInt(boardSize + 1, boardSize * boardSize);
                row = (start / boardSize)  + 1;
                nextRow = ((row - 1) * boardSize)  - (boardSize - 1);
                end = random.nextInt(1,nextRow + 1);
                return new Snake(start,end);
            case LADDER:
                start = random.nextInt(1,boardSize * (boardSize - 1));
                row = (start / boardSize)  + 1;
                nextRow = row * boardSize + 1;
                end = random.nextInt(nextRow, boardSize * boardSize);
                return new Ladder(start,end);
        }
        return null;
    }
}
