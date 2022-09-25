package com.hackathon.snakeladders;

import com.hackathon.snakeladders.constants.GameConstants;
import com.hackathon.snakeladders.models.Game;
import com.hackathon.snakeladders.models.LeaderBoard;

public class Client {
    public static void main(String[] args) {
        // This game is created by using default value
        // We can also capture input from the user on console
        Game game = new Game.Builder().
                setBoard(GameConstants.DEFAULT_BOARD_SIZE)
                .addPlayers(GameConstants.DEFAULT_PLAYER_COUNT).build();
        game.printBoard();
        game.startTheGame();
        System.out.println("*".repeat(10) + " Final Ranking " + "*".repeat(10));
        LeaderBoard.printRanking();
    }
}
