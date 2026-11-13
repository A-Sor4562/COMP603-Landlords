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
 */
public abstract class Phase {
    //Game reference
    protected Game game;
    //int for passCounting, used in both phases
    protected int passCounter;
    
    protected Phase(Game game){
        this.game = game;
        
        //all subclasses must reset the passcounter and empty the dealerDeck
        resetPassCounter();
        clearDealerDeck();
    }
    
    protected void pass(){
        passCounter++;
    }
    
    //Resets passcounter
    protected void resetPassCounter(){
        passCounter = 0;
    }
    
    //refills dealerDeck
    protected void refillDealerDeck(){
        game.getDealerDeck().clearDeck();
        game.getDealerDeck().fillDeck();
        game.getDealerDeck().shuffleDeck();
    }
    
    //Clears dealerDeck
    protected void clearDealerDeck(){
        game.getDealerDeck().clearDeck();
    }
    
    protected void clearPlayerDeck(Player player){
        player.getPlayerDeck().clearDeck();
    }
    
    //Clears all player decks
    protected void clearAllPlayerDecks(){
        clearPlayerDeck(game.getPlayerOne());
        clearPlayerDeck(game.getPlayerTwo());
        clearPlayerDeck(game.getPlayerThree());
    }
    
    //each Phase has the choice for the player of passing or accepting their turn
    protected abstract void acceptTurn();
    
    //each Phase needs to handle the passCounter at certain points of the game
    protected abstract boolean checkPassCounter();
    
    //Phase start/setup
    protected abstract Phase startPhase(Game game);
    
    //Each subclass has this as their main player turn loop.
    protected abstract boolean executePhase();
    
    //Each phase has a condition that ends it
    protected abstract boolean isPhaseFinished();
    

    
}
