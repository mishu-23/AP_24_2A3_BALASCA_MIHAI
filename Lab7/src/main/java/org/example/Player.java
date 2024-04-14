package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {
    private int id;
    private String name;
    private Game game;
    private boolean running;
    private List<Tile> tiles = new ArrayList<>();

    public Player(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setGame(Game game) {
        this.game = game;
        System.out.println("player " + id + " has been set");
        System.out.println(game);
    }

    public void run() {
        while (running) {
            Tile tile = game.extractTile();
            if(tile == null) {
                break;
            }
            else {
                tiles.add(tile);
                System.out.println("player " + id + "gets tile: " + tile);
            }
            try {
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", game=" + game +
                ", tiles=" + tiles +
                '}';
    }
}