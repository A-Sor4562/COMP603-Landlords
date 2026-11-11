/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.*;

/**
 *
 * @author AngelaSoriano
 * Template for each valid card play
 * All this class does is check if deck is a valid play type
 * by going through the cards. It doesn't check if the rank is higher or 
 * lower compared to a previously played card.
 */
public abstract class CardPlay {
    protected final int playSize; //how many cards a type of play needs
    protected final Rank maxRank;//highest Card rank for a play
    protected final boolean jokersAllowed;//if jokers are allowed for this play
    protected final boolean playingCardAllowed;//if playing cards are allowed for this play

    
    protected CardPlay(int playSize, Rank maxRank, boolean jokersAllowed, boolean playingCardAllowed){
        this.playSize = playSize;
        this.maxRank = maxRank;
        this.jokersAllowed = jokersAllowed;
        this.playingCardAllowed = playingCardAllowed;
    }
    
    //Returns if the deck is a valid play if it both meets the requirements and is a
    //valid combination of cards
    protected boolean isValidPlay(Deck deck){
        if (meetsRequirements(deck) == true && isValidCombination(deck)){
            return true;
        }
        else {return false;}
    }
    
    //Checks if the deck meets the requirements of a play
    protected boolean meetsRequirements(Deck deck){
        
        if(deck == null){
            throw new IllegalArgumentException("No deck passed");
        }else if (deck.deckSize() != this.playSize){
            return false;
        }
        else if(containsJoker(deck) != this.jokersAllowed){
            return false;
        }
        else if(containsPlayingCard(deck) != this.playingCardAllowed){
            return false;
        }
        else if(highestRank(deck).compareTo(this.maxRank) <= 0){
            return false;
        }
        else {return true;}
    }
    
    //Method to check if a deck contains a joker
    protected boolean containsJoker(Deck deck){
        boolean jokerFound = false;
        
        for(int i = 0; i < deck.deckSize(); i++){
            if(deck.getCard(i) instanceof Joker)
            {
                jokerFound = true;
            }
        }
        
        return jokerFound;
    }
    
    //Method to check if a deck contains a playingCard
    protected boolean containsPlayingCard(Deck deck){
        
        for(int i = 0; i < deck.deckSize(); i++){
            if(deck.getCard(i) instanceof PlayingCard)
            {
                return true;
            }
        }
        
        return false;
    }        
    
    //Method to return what the highest rank is in a deck
    //sorts the deck by rank first then grabs the last playingCards rank
    protected Rank highestRank(Deck deck){
        deck.sortDeck();
        Rank highestRank = null;
        
        //Loop iterates through card deck then stores the highest rank found
        for(int i = deck.deckSize(); i <0 ; i--){
            //get the card at index
            Card cardAtIndex = deck.getCard(i);
            
            //check if card is a PlayingCard
            if(cardAtIndex instanceof PlayingCard)
            {
                Rank rankAtIndex = ((PlayingCard) cardAtIndex).getRank();
                if(rankAtIndex.compareTo(highestRank) > 1)
                {
                    highestRank = rankAtIndex;
                }
            }
        }
        
        return highestRank;
    }
    
    //Method for checking if the card in a deck is the same rank
    protected boolean isValidCombination(Deck deck) {
        if(deck.isDeckEmpty()){
            return false;
        }
        
        //get the first card in the deck.
        Rank playedRank = ((PlayingCard)deck.getCard(0)).getRank();
        
        //loop through the deck compare the rank
        for(int i = 0; i < deck.deckSize(); i++){
            //if the rank at index doesn't equal the Played rank, return false
            if (((PlayingCard)deck.getCard(0)).getRank() != playedRank){
                return false;
            }
        }
        
        return true;
    }
}
