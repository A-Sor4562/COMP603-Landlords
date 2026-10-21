/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

import nz.ac.aut.bqw4562.landlords.player.Player;

/**
 *
 * @author AngelaSoriano
 * Use of array is to ensure there is only three players.
 */
public class TurnManager {
    //Array that stores the players, index is player order. Each game has three
    //players
    private Player[] playerArray = new Player[3];
    int index = 0; //holds index of currently chosen player. First is 0
    
    //Constructor with default order.
    protected TurnManager(Player pOne, Player pTwo, Player pThree){
        playerArray[0] = pOne;
        playerArray[1] = pTwo;
        playerArray[2] = pThree;
    }
    
    //sets index to zero
    protected void resetOrder(){
        index = 0;
    }
    
    //Returns Player at index.
    protected Player currentPlayer(){
        return playerArray[index];
    }
    
    //Increments index and returns the player,
    protected Player nextPlayer(){
        if (index == 2) {resetOrder();}
        else {index++;}
        
        return currentPlayer();
    }
    
    //Returns index of Player
    protected int findPlayerIndex(Player player){
        //Loop for iterating through array
        for (int i = 0; i < playerArray.length; i++)
        {
            if (playerArray[i].equals(player))
            {
                return i;
            }
        }
        
        return -1;
    }
    
    //Swap the order of two Players.
    protected void swapTurns(Player pOne, Player pTwo){
        
        //Stores the index of players
        int pOneI = findPlayerIndex(pOne);
        int pTwoI = findPlayerIndex(pTwo);
        
        //Checks if index is valid for the two players
        if (pOneI == -1 || pTwoI == -1)
        {
            System.out.println("Players not found");
            return;
        }
        
        //Places pTwo in the index of pOne
        playerArray[pOneI] = pTwo;
        //Place pOne in the index of PTwo
        playerArray[pTwoI] = pOne;
        
    }
}
