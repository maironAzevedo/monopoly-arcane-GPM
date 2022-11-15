package com.projeto.monopoly.model;

public class SlotModel {
    private String name;
    private String owner;
    private int price;
    private int rent_price;
    private String type;

    public SlotModel(String name, String owner, int value, int rent_price, String type) {
        this.name = name;
        this.owner = owner;
        this.price = value;
        this.rent_price = rent_price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "SlotModel{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", price=" + price +
                ", rent_price=" + rent_price +
                ", type='" + type + '\'' +
                '}';
    }
}
