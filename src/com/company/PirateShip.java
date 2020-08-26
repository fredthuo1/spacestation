package com.company;

public class PirateShip extends SpaceObject implements CanMove {

    private int booty;
    private String initial;

    public PirateShip() {
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public int getBooty() {
        return booty;
    }

    public void setBooty( int booty ) {
        this.booty = booty;
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
    public int getY() {
        return super.getY();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
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
    public void moveShip(int x, int y) {
        PirateShip pirateShip = new PirateShip();
        pirateShip.setX( pirateShip.getX() + x );
        pirateShip.setY( pirateShip.getY() + y );
    }

    @Override
    public String toString() {
        return "PirateShip{" +
                "name: " + getName() + "\'" +
                "X coordinate: " + getX() + "\n" +
                "Y coordinate: " + getY() + "\'" +
                "booty: " + booty +
                '}';
    }
}
