package com.company;

import java.util.Scanner;

public class Human extends Player {

    Scanner input = new Scanner(System.in);

    public Human(){
        super("Human");
    }

    //Methods
    @Override
    public Position getShotCoordinates() {
        System.out.println("Enter coordinates x,y (e.g. 2,3):");
        String coordinates = input.nextLine();

        String[] coordinateParts = coordinates.split(",");
        int x = Integer.parseInt(coordinateParts[0]);
        int y = Integer.parseInt(coordinateParts[1]);

        Position userShot = new Position(x,y);
        return userShot;
    }

}
