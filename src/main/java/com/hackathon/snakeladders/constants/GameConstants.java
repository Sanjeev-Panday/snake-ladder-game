package com.hackathon.snakeladders.constants;

import com.hackathon.snakeladders.models.Color;

import java.util.Arrays;
import java.util.List;

public class GameConstants {
    public static final int DICE_VALUE_TO_ENTER_IN_THE_GAME = 12;
    public static final int DEFAULT_BOARD_SIZE = 10;
    public static final int DEFAULT_PLAYER_COUNT = 5;

    public static final List<Color> colorList = Arrays.asList(Color.GREEN,Color.RED,
            Color.BLACK,Color.YELLOW,Color.BLUE);

    public static final int DEFAULT_DICE_COUNT = 2;
}
