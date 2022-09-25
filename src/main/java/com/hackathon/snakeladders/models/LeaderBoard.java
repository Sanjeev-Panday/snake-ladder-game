package com.hackathon.snakeladders.models;

import java.util.HashMap;
import java.util.Map;

public class LeaderBoard {

    private static Map<Player,Integer> ranking = new HashMap<>();
    private static int lastRank;

    public static void addToLeaderBoard(Player player) {
        ranking.putIfAbsent(player,++lastRank);
    }
    public static int getRank(Player p) {
        return ranking.getOrDefault(p,0).intValue();
    }

    public static void printRanking() {
        ranking.forEach((p,rank)->System.out.printf("%s rank is %d \n",p,rank));
    }
}
