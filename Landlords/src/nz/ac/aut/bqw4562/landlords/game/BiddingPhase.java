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
        Create and Shuffle Deck
        Deal cards 17 times.
        Each Player Checks if they like their cards.
        Player will bid or pass.
        No bids, deal cards again.
        Wining bid will be landlord. Set other players as peasant.
        
 */
public class BiddingPhase extends Phase{
    //References to the three players. **refactor to be about player decks instead?
    Player playerOne;
    Player playerTwo;
    Player playerThree;
    Deck dealerDeck;

    //**Might want to refactor and pass turnmanager too
    //**Factory method for phasemanager to use?
    public BiddingPhase(Game game){
        super(game);
        
        //passes the three players from game.
        this.playerOne = game.playerOne;
        this.playerTwo = game.playerTwo;
        this.playerThree = game.playerThree;
        
        //when phase is first started a dealerDeck initialized, filled and shuffled.
        //Creates deck, fills and shuffles it. **Refactor?
        dealerDeck = new Deck();
        dealerDeck.fillDeck();
        dealerDeck.shuffleDeck();
    }
    
    protected boolean executePhase(){
        
        
        return false;
    }
    
    //**refactor into Deck later?
    //Game starts with dealing 17 cards, holding the last three for the landlord.
    //Loops through the players 17 times instead of giving each player 17 cards 
    //in one go.
    protected void dealInitialCards(){

        //Loop 17 times to deal cards **Refactor later? looks ugly
        //**Add checks for if each deck is recieving the right cards?
        //Check at the end if dealer has three cards?
        //**Needs error handling too
        for (int i = 0; i <17 ; i++){
            dealerDeck.dealCard(playerOne.getPlayerDeck());
            dealerDeck.dealCard(playerTwo.getPlayerDeck());
            dealerDeck.dealCard(playerThree.getPlayerDeck());
            
        }
        
    }
    
    
}
