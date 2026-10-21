/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.cards;

/**
 *
 * @author AngelaSoriano
 * Holds all the suits except the Joker
 * Mostly cosmetic, isn't used for game logic, only in deck generation.
 * Package-Private
 * 
 */
enum Suit {
    
    HEARTS, DIAMONDS, CLUBS, SPADES;
    
    //Prints out enum with only the first letter capitalised
    @Override
    public String toString(){
        String suit = name();
        String output = "";
        
        for(int i = 0; i < suit.length(); i++){
            
            if(i != 0){
                output += Character.toLowerCase(suit.charAt(i));
            } else {
                output += suit.charAt(i);
            }
        }
        
        return output;
    }
    
}

