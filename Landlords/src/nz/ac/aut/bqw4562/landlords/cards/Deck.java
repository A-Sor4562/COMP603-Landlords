/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author AngelaSoriano
 * Deck generation, shuffling and sorting
 * Also handles adding and removing cards from decks.
 * 
 */
public class Deck {
    //must be private so only methods can be used for access
    private ArrayList<Card> deckOfCards;
   
    //public constructor
    public Deck(){
        this.deckOfCards = new ArrayList<>();
    };
    
    //method to fill a deck
    public void fillDeck(){
        
        //Loop for Iterating All Enums
        for (Suit s : Suit.values())
        {
            for (Rank r : Rank.values())
            {
                //Add a PlayingCard to deck based on the Suit and Rank the loop is in.
                PlayingCard card = new PlayingCard(s, r);
                this.addCard(card);
            }
        }
        
        //Adds the two jokers to deck
        this.addCard(Joker.redJoker());
        this.addCard(Joker.blackJoker());
        
    }
    
        
    //Shuffle Method, can also use seeds in the future
    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }
    
//    //Sort Method
//    public void sortDeck(){
//        this.deckOfCards.sort(null);
//    }
    
    //Add Method
    public void addCard(Card c){
        this.deckOfCards.add(c);
    }
    
    //Remove method for a specific card, returns the removed card.
    //**add error handling - always returns c without checking if c is actually removed
    public Card removeCard(Card c){
        this.deckOfCards.remove(c);
        return c;
    }
    
    //Remove method, no parameters will always remove the first card on a deck
    //**add error handling, array outof bounds
    public Card removeCard(){
        return this.deckOfCards.remove(0);
    }
    
    //Deal method, remove card from a deck, then add to a new one.
    //This uses the first card on a deck.
    public void dealCard(Deck recipient){
        //recipient will add the card that is removed/returned from this deck.
        recipient.addCard(this.removeCard());
    }
    
    //Empty Deck method, renamed to clearDeck for clarity
    public void clearDeck(){
        this.deckOfCards.clear();
    };
    
    //Check deck if empty, returns boolean
    public boolean isDeckEmpty(){
        return this.deckOfCards.isEmpty();
    }
    
    //Get deckSize
    public int deckSize(){
        return this.deckOfCards.size();
    }
    
    //Printing methods for CLI
    //Print Whole Deck
    public void printDeck(){
        
        for(int i = 0; i < deckSize(); i++){
            System.out.println(deckOfCards.get(i));
        }
    }
    
}    