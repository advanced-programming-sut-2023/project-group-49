package model;

public class Trade {
    private User requester;
    private  User treder;
    private String tradeId;
    public Materials materials;
    public int amount;
    public String message;
    private int price;

    public Trade(Materials materials, int amount, int price, String message) {
        this.amount = amount;
        this.message = message;
        this.price = price;
    }

    public User getRequester() {
        return requester;
    }

    public User getTreder() {
        return treder;
    }

    public String getTradeId() {
        return tradeId;
    }

    public Materials getMaterials() {
        return materials;
    }

    public int getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    public int getPrice() {
        return price;
    }
}
