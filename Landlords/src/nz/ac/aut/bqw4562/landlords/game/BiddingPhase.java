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
        Create and Shuffle Deck
        Deal cards 17 times.
        Each Player Checks if they like their cards.
        Player will bid or pass.
        No bids, deal cards again.
        Wining bid will be landlord. Set other players as peasant.
        
 */
public class BiddingPhase extends Phase{
    private int bid = 0;
    private int passCounter = 0;


    //**Might want to refactor and pass turnmanager too
    //**Factory method for phasemanager to use?
    public BiddingPhase(Game game){
        super(game);
        
        //when phase is first started a dealerDeck initialized, filled and shuffled.
        //Creates deck, fills and shuffles it. **Refactor?
        dealerDeck.fillDeck();
        dealerDeck.shuffleDeck();
    }
    
    //**MISSING
    @Override
    protected boolean executePhase(){
        
        
        return false;
    }
    
    //**refactor into Deck later?
    //Game starts with dealing 17 cards, holding the last three for the landlord.
    //Loops through the players 17 times instead of giving each player 17 cards 
    //in one go. **Change to implement turn manager?
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
    
    //Actual Bidding Phase - each player takes turns to bid or pass.
    //Highest bid is 3, if there is one bid and two consecutive passes, the one bid
    //becomes the landlord.
    //No bids means game have to deal the cards again.
    //At this point, turn order is still default.
    //**Refactor? method is might be very long.
    
    //Increases bid counter, resets passcounter for every bid
    protected void bid(){
        bid++;
        resetPassCounter();
    }
    
    //Resets passcounter
    protected void resetPassCounter(){
        passCounter = 0;
    }
    
    //Clears player decks
    protected void clearPlayerDecks(){
        playerOne.getPlayerDeck().clearDeck();
        playerTwo.getPlayerDeck().clearDeck();
        playerThree.getPlayerDeck().clearDeck();
    }
    
    //resets dealerDeck
    protected void resetDealerDeck(){
        dealerDeck.clearDeck();
        dealerDeck.fillDeck();
        dealerDeck.shuffleDeck();
    }
    
    protected void conductBidding(){
        
        //after loop for bid is run I need to change roles and turn order.
        //also need to reset turnorder.
        //currently the index of turnManager is pointing to the player who bid highest.
        //therefore they become landlord. ** might need to separate into method.
        //**refactor into turnManager??
        Player landlord = turnManager.currentPlayer();
        
        turnManager.nextTurn();//go to next player
        Player peasantOne = turnManager.currentPlayer();
        
        turnManager.nextTurn();//go to next player
        Player peasantTwo = turnManager.currentPlayer();
        
        turnManager.nextTurn();//index is now pointing to landlord
        //swap the turns of the landlord with the person that is at index 0.
        //check if landlord is already at index 0
        int landlordIndex = turnManager.findPlayerIndex(landlord);
        if (landlordIndex != 0)
        {
            //**Refactor/make a method that uses playerIndex instead of playerObjects?
            //Swap the player at index 0 with the landlord.
            //First reset the order.
            turnManager.resetOrder();
            turnManager.swapTurns(turnManager.currentPlayer(), landlord);
            //end of this code block, index of turnManager is still 0/at first
        }
        
        //Change the player roles
        landlord.setAsLandlord();
        peasantOne.setAsPeasant();
        peasantTwo.setAsPeasant();
        
        //Give the rest of the dealerDeck to the Landlord
        while(!dealerDeck.isDeckEmpty()){
            dealerDeck.dealCard(landlord.getPlayerDeck());
        }
        //End of Bidding Phase.
        
    }
}
