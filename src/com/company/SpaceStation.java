package com.company;

import java.util.ArrayList;

public class SpaceStation extends SpaceObject {

    private ArrayList humans;
    private String initial;

    public SpaceStation() {
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    public ArrayList getHumans() {
        return humans;
    }

    public void setHumans(ArrayList humans) {
        this.humans = humans;
    }

    @Override
    public String toString() {
        return "SpaceStation{" +
                "Name: " + getName() + "\'" +
                "X coordinate: " + getX() + "\n" +
                "Y coordinate: " + getY() + "\'" +
                "Number of humans: " + humans.size() +
                '}';
    }
}
