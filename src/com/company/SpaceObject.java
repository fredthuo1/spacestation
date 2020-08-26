package com.company;

public abstract class SpaceObject {

    private String name;
    private int dateBuilt;
    private int x;
    private int y;

    public SpaceObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDateBuilt() {
        return dateBuilt;
    }

    public void setDateBuilt(int dateBuilt) {
        this.dateBuilt = dateBuilt;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "SpaceObject{" +
                "name='" + name + '\'' +
                ", yearBuilt=" + dateBuilt +
                '}';
    }
}
