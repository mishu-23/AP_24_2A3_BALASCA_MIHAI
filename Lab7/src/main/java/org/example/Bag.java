package org.example;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
class Bag {
    private final List<Tile> tiles = new ArrayList<>();

    public Bag(int tokensNumber) {
        for(int i = 1; i <= tokensNumber; i++) {
            for(int j = 1; j <= tokensNumber; j++) {
                if(i != j) {
                    tiles.add(new Tile(i, j));
                }
            }
        }
    }
//  public void shuffle() {}
    public synchronized List<Tile> extractTiles(int howMany) {
        List<Tile> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if(tiles.isEmpty()) {
                break;
            }
            extracted.add(tiles.remove(0));
        }
        return extracted;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "tiles=" + tiles +
                '}';
    }
}