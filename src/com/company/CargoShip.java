package com.company;

public class CargoShip extends SpaceObject implements CanMove {

    private int cargo;
    private String initial;

    public CargoShip() {
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

    public int getCargo() {
        return cargo;
    }

    public void setCargo( int cargo ) {
        this.cargo = cargo;
    }

    @Override
    public void moveShip(int x, int y) {
        CargoShip cargoShip = new CargoShip();
        cargoShip.setX( cargoShip.getX() + x );
        cargoShip.setY( cargoShip.getY() + y );
    }

    @Override
    public String toString() {
        return "CargoShip{" +
                "name: " + getName() + '\'' +
                "X coordinate: " + getX() +"\n" +
                "Y coordinate: " + getY() + '\'' +
                "cargo: '" + cargo + '\'' +
                '}';
    }
}
