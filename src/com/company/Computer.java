package com.company;

import java.util.Random;

public class Computer extends Player {

    Random random = new Random();

    public Computer(){
        super("Computer");
    }

    //Methods
    @Override
    public Position getShotCoordinates() {
        Position position = new Position(random.nextInt(Map.GRID_SIZE), random.nextInt(Map.GRID_SIZE));
        System.out.printf("The computer shoots at: (%d,%d)\n", position.x, position.y);
        return position;
    }
}
