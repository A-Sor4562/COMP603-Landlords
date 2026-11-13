/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

import nz.ac.aut.bqw4562.landlords.cards.Deck;
import nz.ac.aut.bqw4562.landlords.player.Player;


/**
 *
 * @author AngelaSoriano
 * 
 * 
 */
public class Game {
    private static Game gameInstance;
    
    //The three players in each game instance.
    private Player playerOne;
    private Player playerTwo;
    private Player playerThree;
    
    //Each game has a TurnManager
    private TurnManager turnManager;
            
    //Game owns a deck for dealing and holding plays
    private Deck dealerDeck;
    
    private Game(Player pOne, Player pTwo, Player pThree){
        this.playerOne = pOne;
        this.playerTwo = pTwo;
        this.playerThree = pThree;
        
        turnManager = new TurnManager(pOne, pTwo, pThree);
        
        this.dealerDeck = new Deck();
    }
    
    public static synchronized Game getGameInstance(){
        return gameInstance;
    }
    
    public static synchronized Game getGameInstance(Player pOne, Player pTwo, Player pThree){
        if (gameInstance == null){
            gameInstance = new Game(pOne, pTwo, pThree);
        }
        
        return gameInstance;
    }
    
    //method for starting game phases, launch BiddingPhase
    public void startGame(){
        
    }
    //Getters
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
    
    public TurnManager getTurnManager(){
        return turnManager;
    }

    public Deck getDealerDeck() {
        return dealerDeck;
    }

}
