/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

import nz.ac.aut.bqw4562.landlords.cards.Deck;
import nz.ac.aut.bqw4562.landlords.cards.PlayingCard;
import nz.ac.aut.bqw4562.landlords.cards.Rank;
import nz.ac.aut.bqw4562.landlords.player.Player;
import static nz.ac.aut.bqw4562.landlords.game.combinations.CardPlayFinder.CardPlayFinder;
import static nz.ac.aut.bqw4562.landlords.game.combinations.CardPlayFinder.CardPlayMatches;

/**
 *
 * @author AngelaSoriano
 */
public class PlayPhase extends Phase{
    //The current player being asked for cards
    Player currentPlayer = turnManager.currentPlayer();
    int passCounter = 0;
    String comboPlayed;

    public PlayPhase(Game game) {
        super(game);
        
    }
    
    protected boolean executePhase(){
        
        throw new UnsupportedOperationException("Not yet Implemented.");
    }
    
    //Method to ask what player wants to do
    public void askPlayerAction(){
        /*
        Prompts are pass, play card
        Go into the method for asking for cards.
        */
        userIO.displayPrompt("Pass or play?", currentPlayer);
        
        switch(userIO.askUserInput()) {
            case 0:
                System.out.println("Player is passing");
                passCounter++;
                break;
            case 1:
                //if two or more players pass, the previous play is cleared and the comboPlayed is reset
                if(passCounter >= 2){
                    dealerDeck.clearDeck();
                    comboPlayed = null;
                }
                //everytime a player plays, the passcounter is reset
                passCounter = 0;
                //method for checking if play is valid, parameter is a method that
                //returns a deck of player selected cards
                checkValidPlay(playerCardSubmit());
                //go to next player
                break;
            default:
                System.out.println("Invalid input, try again");
                askPlayerAction();
                break;
        
        }
        
    }
    
    //Loop for player submitting cards, returns a deck of selected cards.
    public Deck playerCardSubmit(){
        boolean running = true;
        
        //Deck to hold which cards are being played.
        Deck cardsPlayed = new Deck();
        
        System.out.println("Choose the cards you would like to submit");
        currentPlayer.printPlayerDeck();
        
        while(running){
            int i = userIO.askUserInput();
            
            switch(i){
                case -1:
                    running = false;
                    break;
                default:
                    //add the card to cardsPlayed
                    cardsPlayed.addCard(currentPlayer.playCard(i));
                    break;
            }
            
        }
        
        System.out.println("You chose the following cards:\n");
        cardsPlayed.printDeck();
        
        return cardsPlayed;
        
    }
    
    //Checking if submitted deck is a valid play. the previous play is stored in
    //dealerDeck.
    public void checkValidPlay(Deck selectedCards){
        System.out.println("Checking if play is valid");
        
        //stores if there was a previous play, ie dealerDeck is not empty
        boolean previousPlay = !dealerDeck.isDeckEmpty();

        //if there was no previous play
        if (!previousPlay){
            
            //while selectedCard isn't empty, keep dealing cards from selectedCards
            //which will store the playedDeck
            while(!selectedCards.isDeckEmpty()){
                selectedCards.dealCard(dealerDeck);
            }
            //check what play was submitted and set the comboPlayed
            comboPlayed = CardPlayFinder(dealerDeck);
            //change to the next player
            turnManager.nextTurn();
            
        }
        //if there is a combo in play
        else if(comboPlayed != null){
            
            //if the selectedDeck matches the comboPlayed
            if(CardPlayMatches(comboPlayed, selectedCards))
            {
                //**refactor later
                //check if the rank of the selectedPlayerDeck is higher than the dealerDeck
                //just checks the first card of each
                Rank selectedRank = ((PlayingCard)selectedCards.getCard(1)).getRank();
                Rank dealerRank = ((PlayingCard)dealerDeck.getCard(1)).getRank();
                
                if (selectedRank.compareTo(dealerRank) > 0){
                    //if the selectedRank is higher than the dealerRank
                    //empty the dealerDeck and fill with the selectedCards
                    dealerDeck.clearDeck();
                    
                    while(!selectedCards.isDeckEmpty()){
                        selectedCards.dealCard(dealerDeck);
                    }
                    
                    //go to the next player
                    turnManager.nextTurn();
                }
                
                //else method that when the card isn't valid
            }
        } 
        
    }
    
}
