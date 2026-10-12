/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.cards;

/**
 *
 * @author AngelaSoriano
 * Holds all the ranks of cards except Joker
 * No logic handling
 */
public enum Rank {
    THREE, 
    FOUR, 
    FIVE, 
    SIX, 
    SEVEN, 
    EIGHT, 
    NINE, 
    TEN, 
    JACK, 
    QUEEN, 
    KING, 
    ACE, 
    TWO;
    
    //Prints out enum with only the first letter capitalised
    @Override
    public String toString(){
        String rank = name();
        String output = "";
        
        for(int i = 0; i < rank.length(); i++){
            
            if(i != 0){
                output += Character.toLowerCase(rank.charAt(i));
            } else {
                output += rank.charAt(i);
            }
        }
        
        return output;
    }
    
}
