package com.hackathon.snakeladders.service;

import java.util.Random;

public class DiceService {
    private static Random random = new Random();
    private DiceService() {
        // we need only once Dice instance for this game
    }
    public static int rollDice(int numOfDice) {
        int sum = 0;
        for(int i = 0; i < numOfDice; i++) {
            sum += random.nextInt(1,7);
        }
        return sum;
    }
}
