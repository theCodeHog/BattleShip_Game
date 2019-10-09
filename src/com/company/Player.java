package com.company;

import java.util.Random;

public abstract class Player {

    //Fields
    private String name;
    protected Map map;


    //Constructor
    public Player(String name){
        this.name = name;
        map = new Map();
    }

    //Methods
    public abstract Position getShotCoordinates();

    public void renderMap(){
        System.out.println(name + "'s map: ");
        map.render();
    }

    public void shootAt(Position position){
        map.shootAt(position);
    }

    public boolean hasFloatingShips(){
        return map.hasFloatingShips();
    }

    public void placeShips() {
        int[] shipSizes = {3,4};
        Position startPosition;

        for (int size : shipSizes) {
            do {
                Random random = new Random();
                int x = random.nextInt(Map.GRID_SIZE - size + 1);
                int y = random.nextInt(Map.GRID_SIZE);
                startPosition = new Position(x, y);
            } while (!map.addShip(startPosition, size));
        }
    }


}
