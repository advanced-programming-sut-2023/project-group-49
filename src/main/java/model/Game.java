package model;

import java.util.ArrayList;

public class Game {
    private Map map;
    ArrayList<Player> players;
    public Game(){
        this.players=new ArrayList<>();
    }

    public Map getMap() {
        return map;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
