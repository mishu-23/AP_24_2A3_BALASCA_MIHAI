package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Bag bag;
    private final List<Player> players = new ArrayList<>();

    public Game(int playerNumber, int tokenNumber) {
        for(int i = 1; i <= playerNumber; i++) {
            players.add((new Player("Player " + i, i)));
//            System.out.println("Player " + i + " has been added");
        }
        bag = new Bag(tokenNumber);
    }
    public Tile extractTile() {
        return bag.extractTiles(1).getFirst();
    }
    public void play() {
        System.out.println(this);
        for (Player player : players) {
            player.setGame(this);
            Thread playerThread = new Thread(player);
            playerThread.start();
            try {
                playerThread.join();
            } catch (InterruptedException e) {
                e.getCause();
            }
        }
    }

    @Override
    public String toString() {
        return "Game{" +
                "bag=" + bag +
                ", players=" + players +
                '}';
    }

    public static void main(String args[]) {
        System.out.println("program has started");
        Game game = new Game(4, 4);
        game.play();
        //dupa joc, sacul este gol (piesele sunt la jucatori)
//        System.out.println(game);

    }
}