package model;

public enum Materials {
    GOLD("gold", 0),
    WOOD("wood",0),
    STONE("stone",0);

    private String name;
    private Player player;
    private int amount;


    private Materials(String name,int amount){
        this.name=name;
        this.amount=amount;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Player getPlayer() {
        return player;
    }
}
