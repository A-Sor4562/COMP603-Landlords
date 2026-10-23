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
 */
public abstract class Phase {
    //Game reference
    protected Game game;
    //Turn manager reference
    protected TurnManager turnManager;
    //IO reference **temp
    protected UserInputOutput userIO;
    //Passes the three players from game. ** Refactor?
    Player playerOne;
    Player playerTwo;
    Player playerThree;
    //Deck is used to deal or accept card
    Deck dealerDeck;
    
    public Phase(Game game){
        this.game = game;
        this.turnManager = game.turnManager;
        this.userIO = game.userIO; //** temp
        
        //**Refactor
        //passes the three players from game.
        this.playerOne = game.playerOne;
        this.playerTwo = game.playerTwo;
        this.playerThree = game.playerThree;
    }
    
    //Each subclass has this as their main player turn loop.**Re-do later
    //Phase will return true on completion, return false if not
    protected abstract boolean executePhase();
    
    //Each phase will have to display cards to players. CLI version **refactor to UI
    //later.
}
