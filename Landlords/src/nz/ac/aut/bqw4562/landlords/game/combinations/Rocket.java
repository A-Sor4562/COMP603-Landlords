/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.*;

/**
 *
 * @author AngelaSoriano
 * Pair of two jokers
 * Beats everything else
 */
public class Rocket extends CardPlay{
    //private constructor for method only initialization
    private Rocket(){
        super(2, null, true, false);
    } 
    
    //used when checking if deck matches a play
    protected static boolean RocketChecker(Deck deck){
        Rocket rocket = new Rocket();
        
        return rocket.isValidPlay(deck);
    }    
}
