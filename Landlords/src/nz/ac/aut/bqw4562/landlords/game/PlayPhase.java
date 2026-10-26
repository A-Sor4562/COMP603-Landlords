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
 */
public class PlayPhase extends Phase{
    //The current player being asked for cards
    Player currentPlayer = turnManager.currentPlayer();    

    public PlayPhase(Game game) {
        super(game);
        
    }
    
    protected boolean executePhase(){
        
        /*
        Game play loop. Ask player for card. Check if valid. Go to next player
        */
        while(true){
            
        }
        
        return false;
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
                break;
            case 1:
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
        //if the dealerDeck is empty, the play is automatically valid
        //add the cards from d to the dealerDeck
        
        boolean previousPlay = dealerDeck.isDeckEmpty();
        
        if (previousPlay){
            //while dealerDeck isn't empty, keep dealing cards from selectedCards
            while(!dealerDeck.isDeckEmpty())
            selectedCards.dealCard(dealerDeck);
            //change to the next player
            turnManager.nextTurn();
        }
    }
}
