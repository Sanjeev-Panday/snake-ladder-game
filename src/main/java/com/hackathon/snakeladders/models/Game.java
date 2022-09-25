package com.hackathon.snakeladders.models;

import com.hackathon.snakeladders.constants.GameConstants;
import com.hackathon.snakeladders.service.DiceService;

import java.util.*;

public class Game {
    private final Queue<Player> playerQueue;
    private final Map<Player,Integer> playerPosition;
    private final Board board;
    private final int totalBoardSize;
    private final Scanner scanner;
    private Game(int boardSize,Board board, Queue<Player> playerQueue) {
        this.playerQueue = playerQueue;
        playerPosition = new HashMap<>();
        playerQueue.forEach(p -> playerPosition.put(p,0));
        this.totalBoardSize = boardSize * boardSize;
        this.board = board;
        scanner = new Scanner(System.in);

    }
    public void startTheGame() {
        // This game runs till all player reaches WON status
        System.out.println("********* Game on ************* ");
        while(!playerQueue.isEmpty()) {
            Player p = playerQueue.poll();
            //System.out.println(p + " is Rolling the dice \n");
            int diceValue = DiceService.rollDice(GameConstants.DEFAULT_DICE_COUNT);
            //System.out.println("Dice value " + diceValue);
            switch (p.getStatus()) {
                case WAITING:
                    if(diceValue == GameConstants.DICE_VALUE_TO_ENTER_IN_THE_GAME) {
                        p.setStatus(PlayerStatus.IN_THE_GAME);
                        p.setPosition(1);
                        playerPosition.put(p,1);
                    }
                    playerQueue.add(p);
                    break;
                case IN_THE_GAME:
                    nextMove(p,diceValue);
                    playerQueue.add(p);
                    break;
                case WON:
                    System.out.printf("Player %s has reached the end of board. Ranking is %d \n",p, LeaderBoard.getRank(p));
            }
            //printPlayer();
        }
    }

    private void nextMove(Player player,int diceValue) {
        int oldValue = playerPosition.get(player);
        int newValue = oldValue + diceValue;
        if(newValue >= totalBoardSize) {
            player.setStatus(PlayerStatus.WON);
            player.setPosition(newValue);
            LeaderBoard.addToLeaderBoard(player);
            return;
        }
        GameCharacter gameCharacter = board.getGameCharacters().get(newValue);
        if(gameCharacter != null) {
            newValue = gameCharacter.getEnd();
        }
        player.setPosition(newValue);
        playerPosition.put(player,newValue);
    }
    public void printBoard() {
        System.out.println(board);
    }
    public void printPlayer() {
        System.out.println(playerPosition);
    }
    public static class Builder {
        private Board board;
        private int boardSize;
        private final Queue<Player> playerQueue;
        public Builder() {
            playerQueue = new ArrayDeque<>();
        }
        public Builder setBoard(int boardSize){
            this.board = Board.Builder.withSize(boardSize).build();
            this.boardSize = boardSize;
            return this;
        }
        public Builder addPlayers(int playerCount) {
            if(playerCount > GameConstants.DEFAULT_PLAYER_COUNT) {
                throw new IllegalArgumentException("Max player count can only be " + GameConstants.DEFAULT_PLAYER_COUNT);
            }
            for(int i = 0; i < playerCount; i++) {
                playerQueue.add(Player.Builder.
                        createBuilder(PlayerType.HUMAN).
                        setColor(GameConstants.colorList.get(i)).build());
            }
            return this;
        }
        public Game build() {
            return new Game(boardSize,board,playerQueue);
        }
    }
}
