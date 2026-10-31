/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.cards;

import java.util.Comparator;

/**
 *
 * @author AngelaSoriano
 * This class implements Comparator to sort
 * both card types using suit, rank and joker colors
 * 
 */
public class CardOrder implements Comparator<Card>{
    
    public int compare(Card a, Card b){
        //checks if either cards are null
        if(a == null || b == null){
            throw new IllegalArgumentException("Cards cannot be null");
        }
        
        //Two jokers
        if(a instanceof Joker && b instanceof Joker){
            return compare((Joker) a, (Joker) b);
        }
        //Joker + PlayingCard
        else if(a instanceof Joker && b instanceof PlayingCard){
            return compare((Joker) a, (PlayingCard) b);
        }
        //PlayingCard + Joker
        else if(a instanceof PlayingCard && b instanceof Joker){
            return compare((PlayingCard) a, (Joker) b);
        }
        //Two PlayingCards
        else if(a instanceof PlayingCard && b instanceof PlayingCard){
            return compare((PlayingCard) a, (PlayingCard) b);
        }
        else
        {
        //By default throws error if they didn't go through if branch
        throw new IllegalArgumentException("Card couldn't be compared");
        }
        
    }
    
    //Compares two Joker cards
    private int compare(Joker a, Joker b){
        //If first card is a red joker, always return one
        if(a.getJoker().equalsIgnoreCase("Red")){
            return 1;
        }
        
        //If first card is not red, it can only be the black joker which is below
        //red jokers
        return -1;
    }
    
    //Compares PlayingCard and Joker, always returns -1, as jokers are higher
    private int compare(PlayingCard a, Joker b){
        return -1;
    }
    
    //Compares Joker and Playing card, always returns 1 for joker priority
    private int compare(Joker a, PlayingCard b){
        return 1;
    }
    
    //Compares two PlayingCards
    private int compare(PlayingCard a, PlayingCard b){
        return a.compareTo(b);
    }
    
}

