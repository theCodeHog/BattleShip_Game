package com.company;

public class BattleShipsProgram {

    Computer computerPlayer = new Computer();
    Human humanPlayer = new Human();


    //Fields

    //Constructor
    public BattleShipsProgram(){
        computerPlayer.placeShips();
        humanPlayer.placeShips();
    }


    //Methods
    public void startProgram(){

        computerPlayer.renderMap();
        humanPlayer.renderMap();


        do {
            Position shotCoordinates = humanPlayer.getShotCoordinates();
            computerPlayer.shootAt(shotCoordinates);
            computerPlayer.renderMap();

            shotCoordinates = computerPlayer.getShotCoordinates();
            humanPlayer.shootAt(shotCoordinates);
            humanPlayer.renderMap();


        }while (computerPlayer.hasFloatingShips() && humanPlayer.hasFloatingShips());

        if (humanPlayer.hasFloatingShips()){
            System.out.println("You have won the game!");
        }
        else{
            System.out.println("You lost. GAME OVER.");
        }

    }

}
