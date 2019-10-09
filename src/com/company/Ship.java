package com.company;

public class Ship {

    //Fields
    private Position[] positions;
    private int size;
    private int hits = 0;


    //Constructor
    public Ship(int size, Position startPosition){
        this.size = size;
        positions = getPositions(size, startPosition);
    }

    //Methods
    public static Position[] getPositions(int size, Position startPosition){
        Position[] calculatedPositions = new Position[size];
        calculatedPositions[0] = startPosition;
        for (int i = 1; i < size ; i++) {
            calculatedPositions[i] = new Position(startPosition.x+i, startPosition.y);
        }
        return calculatedPositions;
    }

    public boolean isFloating(){
        if (hits < size)
            return true;
        return false;
    }

    public boolean hasPosition(Position position){
        for (Position myPosition : positions) {
            if (myPosition.x == position.x && myPosition.y == position.y) {
                return true;
            }
        }
        return false;
    }

    public void addHit(){
        hits++;
    }

}
