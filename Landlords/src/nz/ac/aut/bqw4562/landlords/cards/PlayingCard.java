/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.cards;

/**
 *
 * @author AngelaSoriano
 * Handles the regular 52 PlayingCards.
 * No logic is coded here//Comparable implemented for sorting
 */
public class PlayingCard extends Card implements Comparable<PlayingCard>{
    
    //Private fields to prevent changes
    private final Suit suit;
    private final Rank rank;
    
    //Card maker, protected to keep access limited to the Deck
    protected PlayingCard(Suit suit, Rank rank)
    {
        this.suit = suit;
        this.rank = rank;
    }
    
    //getters for suits and ranks
    //suits mostly won't be used as the game logic doesn't rely on it
    public Suit getSuit(){
        return this.suit;
    }
    
    public Rank getRank(){
        return this.rank;
    }
    
    //Easy printing of Suit and Rank
    //Format is "Suit of Rank"
    @Override
    public String toString() 
    {
        return this.rank + " of " + this.suit;
    }
    
    //compareTo implementation, compares suit then rank
    public int compareTo(PlayingCard c){
        
        //If suit is the same, compare the ranks
        if (this.suit.equals(c.suit)){
            return this.rank.compareTo(c.rank);
        }
        
        return this.suit.compareTo(c.suit);
    }
    
}
