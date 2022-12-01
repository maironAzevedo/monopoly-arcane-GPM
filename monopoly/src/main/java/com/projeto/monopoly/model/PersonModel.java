package com.projeto.monopoly.model;

import javafx.scene.image.ImageView;

import java.util.List;

public class PersonModel {
    private String name;
    private double sale = 300;
    private List<PropertyModel> properties = null;
    private Boolean isStuck = false;
    private Boolean isVocation = false;
    private int roundStoped = 0;
    private String houseCurrent = "column_10 row_10";
    private ImageView player;

    public PersonModel(
            String name,
            ImageView player
    ){
        this.name = name;
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public List<PropertyModel> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyModel> properties) {
        this.properties = properties;
    }

    public Boolean getStuck() {
        return isStuck;
    }

    public void setStuck(Boolean stuck) {
        isStuck = stuck;
    }

    public Boolean getVocation() {
        return isVocation;
    }

    public void setVocation(Boolean vocation) {
        isVocation = vocation;
    }

    public int getRoundStoped() {
        return roundStoped;
    }

    public void setRoundStoped(int roundStoped) {
        this.roundStoped = roundStoped;
    }

    public String getHouseCurrent() {
        return houseCurrent;
    }

    public void setHouseCurrent(String houseCurrent) {
        this.houseCurrent = houseCurrent;
    }

    public ImageView getPlayer() {
        return player;
    }

    public void setPlayer(ImageView idPin) {
        this.player = idPin;
    }
}
