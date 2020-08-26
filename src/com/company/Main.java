package com.company;

import com.company.SpaceObject;

import java.util.ArrayList;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Main {

    public static void main(String[] args) {
 	// write your code here
        Scanner scanner = new Scanner(System.in);
        // Space object array list
        ArrayList<SpaceObject> spaceObjects = new ArrayList<>();

        // Ask user number of space objects

        System.out.println("How many Space Objects would you like to work with?\n" +
                "Enter a number from 1-9: ");
        int numberOfSpaceObjects = scanner.nextInt();

        System.out.println( "Enter the Space Objects information!" );

        for ( int i = 0; i < numberOfSpaceObjects; i++ ) {
            System.out.println( "For object " + ( i+ 1 ) + ". Choose Object type.\n" +
                    "For Cargo Ship enter 1!:\n" +
                    "For Pirate Ship enter 2!\n" );

            int object = scanner.nextInt();

            if ( object == 1 ) {
                spaceObjects.add( createCargoShip() );
            } else if ( object == 2) {
                spaceObjects.add( createPirateShip() );
            } else {
                System.out.println( "Invalid choice! \n" +
                        "For Cargo Ship enter 1!:\n" +
                        "For Pirate Ship enter 2!\n" );
                int ob = scanner.nextInt();

                if ( ob == 1 ) {
                    spaceObjects.add( createCargoShip() );
                } else if ( ob == 2) {
                    spaceObjects.add( createPirateShip() );
                } else {
                    System.out.println( "You are not serious! Project Terminated" );
                    exit();
                }
            }
        }

        System.out.println( "Congratulations on your Ships! You can now create a Space Station!" );

        spaceObjects.add( createSpaceStation() );

        display( spaceObjects );

        changeStatus( spaceObjects );

        changeStatus( spaceObjects );

    }

    public static CargoShip createCargoShip() {
        Scanner scanner = new Scanner( System.in );
        CargoShip cargoShip = new CargoShip();
        System.out.println( "Enter Cargo Ship name: " );
        String name = scanner.nextLine();
        cargoShip.setName( name );
        System.out.println( "Enter the amount of Cargo on the Ship: " );
        int cargo = scanner.nextInt();
        cargoShip.setCargo( cargo );
        System.out.println( "Enter the location of the ship.\n" +
                "X coordinate: " );
        cargoShip.setX( scanner.nextInt() );
        System.out.println( "Y coordinate: " );
        cargoShip.setY( scanner.nextInt() );
        return cargoShip;
    }

    public static PirateShip createPirateShip() {
        Scanner scanner = new Scanner( System.in );
        PirateShip pirateShip = new PirateShip();
        System.out.println( "Enter pirate Ship name: " );
        pirateShip.setName( scanner.nextLine() );
        System.out.println( "Enter amount of booty: " );
        pirateShip.setBooty( scanner.nextInt() );
        System.out.println( "Enter location of ship:'\n" +
                "X coordinate: " );
        pirateShip.setX( scanner.nextInt() );
        System.out.println( "Y coordinate: " );
        pirateShip.setY( scanner.nextInt() );
        return  pirateShip;
    }

    public static SpaceStation createSpaceStation() {
        Scanner scanner = new Scanner( System.in );
        SpaceStation spaceStation = new SpaceStation();
        System.out.println( "Enter Space Station name: " );
        spaceStation.setName( scanner.nextLine() );
        System.out.println( "Enter number of people in the station: " );
        int numberOfPeople = scanner.nextInt();
        ArrayList humans = new ArrayList();
        for ( int j = 0; j < numberOfPeople; j++ ) {
            System.out.println( "Enter human name: " );
            humans.add( scanner.nextLine() );
            scanner.nextLine();
        }
        spaceStation.setHumans( humans );
        System.out.println( "Enter Space Station Location: \n" +
                "X coordinate: " );
        spaceStation.setX( scanner.nextInt() );
        System.out.println( "Y coordinate: " );
        spaceStation.setY( scanner.nextInt() );
        return spaceStation;
    }

    public static void display( ArrayList<SpaceObject> spaceObjects ) {
        String[][] location = new String[10][10];
        String initial;
        spaceObjects.forEach( spaceObject -> {
            if ( spaceObject instanceof CargoShip ) {
                ((CargoShip) spaceObject).setInitial( "C" );
                location[spaceObject.getX()][spaceObject.getY()] = "C"+ spaceObjects.indexOf(spaceObject);
            } else if ( spaceObject instanceof PirateShip ) {
                ((PirateShip) spaceObject).setInitial( "P" );
                location[spaceObject.getX()][spaceObject.getY()] = "P"+ spaceObjects.indexOf(spaceObject);
            } else if ( spaceObject instanceof SpaceStation ) {
                ((SpaceStation) spaceObject).setInitial( "S" );
                location[spaceObject.getX()][spaceObject.getY()] = "S"+ spaceObjects.indexOf(spaceObject);
            }
        } );

        for ( int i = 0;  i < location.length; i++ ) {
            for (int j = 0; j < location[i].length; j++) {
                if ( location[i][j]==null ) {
                    System.out.print( "**"  + "\t");
                } else {
                    System.out.print(location[i][j] + "\t");
                }
            }
            System.out.println();
        }

        infoPrint( spaceObjects );
    }

    public static void infoPrint( ArrayList<SpaceObject> spaceObjects ) {
        spaceObjects.forEach( spaceObject -> {
            System.out.println( spaceObject.toString() );
        } );
    }

    public static void changeStatus( ArrayList<SpaceObject> spaceObjects ) {
        System.out.println( "Do you want to change the status of a Space Ship?\n" +
                "Enter Yes or No:" );
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        SpaceObject spaceObject = null;
        if ( input.toLowerCase().equals("yes".toLowerCase()) ) {
            System.out.println( "Enter the name of the Space Object:" );
            String spaceObjectName = scanner.nextLine();
            System.out.println( "What do you want to do with " + spaceObjectName + ":\n" +
                    "To change the ship type enter 1!\n" +
                    "To move the ship position enter 2!\n" );
            int opt = scanner.nextInt();
            for ( int i = 0; i < spaceObjects.size(); i++ ) {
                if ( spaceObjects.get(i).getName().toLowerCase().equals( spaceObjectName.toLowerCase() ) ) {
                    spaceObject = spaceObjects.get(i);
                }
            }
            option( opt, spaceObject , spaceObjects );
        } else if ( input.toLowerCase().equals("no".toLowerCase()) ) {
            System.out.println( "Have a nice day!" );
        } else {
            System.out.println( "Invalid input try again!" );
            changeStatus( spaceObjects );
        }
    }

    public static void option( int option, SpaceObject spaceObject, ArrayList<SpaceObject> spaceObjects) {
        Scanner scanner = new Scanner( System.in );

        if ( option == 1 ) {
            System.out.println( "What ship would you like to change " + spaceObject.getName() + " to?\n" +
                    "For Cargo Ship enter 1: \n" +
                    "For Pirate Ship enter 2: " );
            spaceObjects.set( spaceObjects.indexOf( spaceObject ), createObject( scanner.nextInt(), spaceObject ));
        } else if ( option == 2 ) {
            System.out.println( "Where would you like to move " + spaceObject.getName() + "\n" +
                    "Enter N distance: \n" );
            int n = scanner.nextInt();
            System.out.println( "Enter S distance: " );
            int s = scanner.nextInt();
            System.out.println( "Enter E distance: " );
            int e = scanner.nextInt();
            System.out.println( "Enter W distance: " );
            int w = scanner.nextInt();
            moveSpaceShip( ( spaceObject.getX() - e + w ), ( spaceObject.getY() + n - s ), spaceObject, spaceObjects );
        } else {
            System.out.println( "Invalid option. Try again:" );
            scanner.nextLine();
            option( scanner.nextInt(), spaceObject, spaceObjects);
        }

        display( spaceObjects );
    }

    public static SpaceObject createObject( int option, SpaceObject spaceObject ) {
        Scanner scanner = new Scanner( System.in );
        SpaceObject spaceObject1 = spaceObject;
        if ( option == 1 ) {
            if ( spaceObject instanceof CargoShip ) {
                System.out.println( "Space Ship is already a Cargo Ship. Can't change it into s Cargo ship." );
            } else {
                spaceObject1 = createCargoShip();
            }
        } else  if ( option == 2 ) {
            if ( spaceObject instanceof PirateShip ) {
                System.out.println( "Space Ship is already a Pirate Ship. Can't change is into a Pirate Ship." );
            } else {
               spaceObject1 = createPirateShip();
            }
        } else {
            System.out.println( "Invalid option try again: ");
            spaceObject1 = createObject( scanner.nextInt(), spaceObject );
        }
        return spaceObject1;
    }

    public static void moveSpaceShip(int x, int y, SpaceObject spaceObject, ArrayList<SpaceObject> spaceObjects) {
        if ( x < 0 || y < 0 ) {
            System.out.println( "Invalid position! The ship has disappeared of the grid!!!" );
        }
        for ( int i = 0; i < spaceObjects.size(); i++ ) {
            if ( spaceObjects.get( i ).getX() == x && spaceObjects.get( i ).getY() == y && ( spaceObjects.get( i ) instanceof CargoShip || spaceObjects.get( i ) instanceof PirateShip  )) {
                spaceObjects.remove( spaceObject );
                spaceObjects.remove( i );
                System.out.println( "!!! Space Ships have Crashed !!!\n" +
                        spaceObject.getName() + " and " + spaceObjects.get( i ) +
                        " have been destroyed!");
            } else if ( spaceObjects.get( i ).getX() == x && spaceObjects.get( i ).getY() == y && spaceObjects.get( i ) instanceof SpaceStation ) {
                spaceObject.setX( x );
                spaceObject.setY( y );
                System.out.println(  spaceObject.getName() + " has been docked at " + spaceObjects.get( i ).getName() + "!!!");
            }
            else {
                spaceObject.setX( x );
                spaceObject.setY( y );
            }
        }

        display( spaceObjects );

       /* spaceObjects.forEach( spaceObject1 -> {
            if ( ( spaceObject1.getX() == x ) && ( spaceObject1.getY() == y ) ) {
                spaceObjects.remove( spaceObject1 );
                spaceObjects.remove( spaceObject );
                System.out.println( "!!!! Space Ships have Crashed !!!\n" +
                        spaceObject.getName() + " and " + spaceObject1.getName() +
                        " have been destroyed!");
            } else {
                spaceObject.setX(x);
                spaceObject.setY(y);
            }
            display( spaceObjects );
        } );

        */
    }
}
