/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

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
    private int bid;
    private int passCounter;

    //private constructor for method only instantiation
    private BiddingPhase(Game game){
        super(game);
        
        //when phase is first started a dealerDeck initialized, filled and shuffled.
        //Creates deck, fills and shuffles it. uses resetDealerDeck function
        resetDealerDeck();
    }
    
    //Game starts with dealing 17 cards, holding the last three for the landlord.
    //Loops through the players 17 times instead of giving each player 17 cards 
    //in one go.
    protected void dealInitialCards(){

        //Loop 17 times to deal cards
        for (int i = 0; i <17 ; i++){
            
            game.getDealerDeck().dealCard(game.getPlayerOne().getPlayerDeck());
            game.getDealerDeck().dealCard(game.getPlayerTwo().getPlayerDeck());
            game.getDealerDeck().dealCard(game.getPlayerThree().getPlayerDeck());
            
        }
        
    }
    
    //Increases bid counter, resets passcounter for every bid
    protected void bid(){
        bid++;
        resetPassCounter();
    }
    
    protected void resetBid(){
        bid = 0;
    }
    
    //Resets passcounter
    protected void resetPassCounter(){
        passCounter = 0;
    }
    
    //Clears player decks
    protected void clearPlayerDecks(){
        game.getPlayerOne().getPlayerDeck().clearDeck();
        game.getPlayerTwo().getPlayerDeck().clearDeck();
        game.getPlayerThree().getPlayerDeck().clearDeck();
    }
    
    //resets dealerDeck
    protected void resetDealerDeck(){
        game.getDealerDeck().clearDeck();
        game.getDealerDeck().fillDeck();
        game.getDealerDeck().shuffleDeck();
    }
    
    @Override
    protected Phase startPhase(Game game) {
        return new BiddingPhase(game);
    }
    
    //**MISSING
    @Override
    protected boolean executePhase(){
        
        return false;
    }
    
    //method that checks the passCounter, three passes mean all players passed, reset decks.
    //two consecutive passes mean the last player who bid will become landlord
    protected boolean checkPassCounter(){
        if (passCounter == 3){
            resetDealerDeck();
            clearPlayerDecks();
            return true;
        }
        //if passCounter is 2, the index of turnManager needs to go to the next player as they will be the ones who bid.
        else if (passCounter == 2){
            game.getTurnManager().nextTurn();
            //method that changes the roles.
            return true;
        }
        else {
           return false;
        }
    }
    
    //Method that checks if the bid has reached 3, check if passcounter requirements are met, otherwise continue with turn.
    protected boolean checkBid(){
        if (bid == 3){
            //method that changes the roles.
            return true;
        }
        else if (checkPassCounter()){
            return true;
        }
        else {
            return false;
        }
    }
    
    //Method that changes the role of players, turnManager index must be at the landlord
    protected void setRolesAndTurnOrder(){
        //changes the current player to be landlord
        game.getCurrentPlayer().setAsLandlord();
        
        //places landlord first in turnManager
        game.getTurnManager().placeFirst(game.getCurrentPlayer());
        
        //goes to the next player and sets as peasant, does this twice
        for(int i = 0; i < 2; i++){
            game.getTurnManager().nextTurn();
            game.getCurrentPlayer().setAsPeasant();
        }
        
    }
    
    //Method gives landlord the rest of the cards
    protected void giveLandlord(){
        //makes sure the turn manager is pointing to landlord
        game.getTurnManager().resetIndex();
        
        while(!game.getDealerDeck().isDeckEmpty()){
            game.getDealerDeck().dealCard(game.getCurrentPlayer().getPlayerDeck());
        }
    }
    
    protected void conductBidding(){
        //Give the rest of the dealerDeck to the Landlord

        //End of Bidding Phase.
        
    }

}
