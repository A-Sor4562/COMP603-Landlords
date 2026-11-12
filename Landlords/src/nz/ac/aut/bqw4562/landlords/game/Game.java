/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

import nz.ac.aut.bqw4562.landlords.cards.Deck;
import nz.ac.aut.bqw4562.landlords.player.Player;
import nz.ac.aut.bqw4562.landlords.util.*;

/**
 *
 * @author AngelaSoriano
 * 
 * 
 */
public class Game {

    //The three players in each game instance.
    private Player playerOne;
    private Player playerTwo;
    private Player playerThree;
    
    //Each game has a TurnManager and PhaseManager
    private TurnManager turnManager;
    private PhaseManager phaseManager;
    
    //Game will also have this for user input **Temp
    protected UserInputOutput userIO;
    
    //Game owns a deck for dealing and holding plays
    private Deck dealerDeck;
    
    //Game owns a phase which holds the current phase
    private Phase currentPhase = null;
    
    public Game(Player pOne, Player pTwo, Player pThree){
        this.playerOne = pOne;
        this.playerTwo = pTwo;
        this.playerThree = pThree;
        
        turnManager = new TurnManager(pOne, pTwo, pThree);
        phaseManager = new PhaseManager();
        userIO = new UserInputOutput();
        
        this.dealerDeck = new Deck();
    }
    
    
    //What the game needs to do when starting.
    //Passes the three player instances to turnManager.
    public void start(){
        
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Player getPlayerThree() {
        return playerThree;
    }
    
    public Player getCurrentPlayer(){
        return turnManager.currentPlayer();
    }

    public PhaseManager getPhaseManager() {
        return phaseManager;
    }
    
    public TurnManager getTurnManager(){
        return turnManager;
    }

    public Deck getDealerDeck() {
        return dealerDeck;
    }

}
