package com.company;

import java.util.ArrayList;

public class Map {

    private enum SquareState {

        NONE,
        MISS,
        HIT,

    }

    //Fields
    public final static int GRID_SIZE = 5;
    SquareState[][] grid = new SquareState[GRID_SIZE][GRID_SIZE];
    private ArrayList<Ship> ships = new ArrayList<>();



    //Constructor
    public Map(){
        for (int y = 0; y < GRID_SIZE ; y++) {
            for (int x = 0; x < GRID_SIZE ; x++) {
                grid[y][x] = SquareState.NONE;
            }
        }
    }


    //Methods

    private String getSymbol(SquareState squareState){
        switch (squareState){
            case HIT:
                return "[*]";
            case MISS:
                return "[x]";
            default:
                return "[ ]";
        }
    }

    private boolean isAnyShipHit(Position position){
        for (Ship ship : ships) {
            if (ship.hasPosition(position))
                return true;
        }
        return false;
    }

    public void render(){
        String xValues = "  ";
        for (int i = 0; i < GRID_SIZE; i++) {
            xValues+=" "+i+" ";
        }
        System.out.println(xValues+" = x");

        for (int y = 0; y < GRID_SIZE ; y++) {
            String row = ""+y+" ";

            for (int x = 0; x < GRID_SIZE ; x++) {
                if ( false && !ships.isEmpty() && isAnyShipHit(new Position(x,y))){
                    row += "[B]";
                }
                else {
                    row += getSymbol(grid[y][x]);
                }
            }
            System.out.println(row);
        }
        System.out.println(" ");
    }

    public boolean addShip(Position position, int size){
        Position[] positions = Ship.getPositions(size, position);
        for (Position shipPosition : positions) {
            for (Ship alreadyAddedShip : ships) {
                if (alreadyAddedShip.hasPosition(shipPosition)){
                    return false;
                } else{
                }
            }
        }
        ships.add(new Ship(size, position));
        return true;
    }

    public void shootAt(Position position){
        if (grid[position.y][position.x] == SquareState.NONE) {
            for (Ship ship : ships) {
                if (ship.hasPosition(position)) {
                    ship.addHit();
                    grid[position.y][position.x] = SquareState.HIT;
                    System.out.println("BOOM! We have a hit!");
                    break;
                }
            }
            if (grid[position.y][position.x] != SquareState.HIT) {
                grid[position.y][position.x] = SquareState.MISS;
                System.out.println("Miss.");
            }
        }
        else{
            System.out.println("Already shot at this square.");
        }
    }

    public boolean hasFloatingShips(){
        for (Ship ship : ships) {
            if (ship.isFloating())
                return true;
        }
        return false;
    }

}
