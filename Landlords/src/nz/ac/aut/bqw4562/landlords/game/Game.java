/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

import nz.ac.aut.bqw4562.landlords.player.Player;

/**
 *
 * @author AngelaSoriano
 * 
 * 
 */
public class Game {
    //The three players in each game instance.
    protected Player playerOne;
    protected Player playerTwo;
    protected Player playerThree;
    
    //Each game has a TurnManager and PhaseManager
    protected TurnManager turnManager;
    protected PhaseManager phaseManager;
    
    //**Refactor/modify constructor
    public Game(){
        turnManager = new TurnManager(playerOne, playerTwo, playerThree);
        phaseManager = new PhaseManager();
        
    }
    
    //**Temp at the moment, written for testing.
    public Game(Player pOne, Player pTwo, Player pThree){
        this.playerOne = pOne;
        this.playerTwo = pTwo;
        this.playerThree = pThree;
        
        turnManager = new TurnManager(pOne, pTwo, pThree);
        phaseManager = new PhaseManager();
    }
    
    //What the game needs to do when starting.
    //Passes the three player instances to turnManager.
    public void start(){
        
    }

    
}
