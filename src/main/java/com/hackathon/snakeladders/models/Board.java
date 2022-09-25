package com.hackathon.snakeladders.models;

import com.hackathon.snakeladders.factory.GameCharacterFactory;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final int boardSize;
    private Map<Integer,GameCharacter> gameCharacters;
    private Board(int boardSize, Map<Integer,GameCharacter> gameCharacters) {
        this.boardSize = boardSize;
        this.gameCharacters = gameCharacters;
    }
    public Map<Integer, GameCharacter> getGameCharacters() {
        return gameCharacters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Board size = "+ boardSize).append("\n");
        gameCharacters.values().forEach(x -> {
            sb.append(x.getType().name() +" start at : "+x.getStart()+" end at : "+ x.getEnd());
            sb.append("\n");
        });
        return sb.toString();
    }

    public static class Builder {
        private int boardSize;
        private Map<Integer,GameCharacter> gameCharacters = new HashMap<>();
        private GameCharacterFactory characterFactory;
        public Builder(int boardSize) {
            this.boardSize = boardSize;
            this.characterFactory = new GameCharacterFactory(boardSize);
        }

        public static Builder withSize(int boardSize) {
            return new Builder(boardSize);
        }
        private void addSnakes() {
            while(gameCharacters.size() < boardSize) {
                GameCharacter snake = this.characterFactory.createCharacter(CharacterType.SNAKE);
                if(isCharacterValid(snake)) {
                    this.gameCharacters.put(snake.getStart(),snake);
                }
            }
        }

        private void addLadders() {
            while(gameCharacters.size() < 2 * boardSize) {
                GameCharacter ladder = this.characterFactory.createCharacter(CharacterType.LADDER);
                if (isCharacterValid(ladder)) {
                    this.gameCharacters.put(ladder.getStart(), ladder);
                }
            }
        }

        private boolean isCharacterValid(GameCharacter character) {
            return gameCharacters.get(character.getStart()) == null
                    && gameCharacters.get(character.getEnd()) == null;
        }
        public Board build() {
            addSnakes();
            addLadders();
            return new Board(boardSize, gameCharacters);
        }
    }
}
