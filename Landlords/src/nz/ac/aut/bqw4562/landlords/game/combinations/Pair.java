/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.*;
/**
 *
 * @author AngelaSoriano
 * Two cards of the same rank per turn
 * Goes from three to Two
 * No jokers allowed
 */
public class Pair extends CardPlay {
    private static Pair pairPlay = null;
    
    //private constructor for method only initialization
    private Pair(){
        super(2, Rank.TWO, false, true);
    }
    
    //Access Method
    public static synchronized Pair pairPlay()
    {
        if(pairPlay == null){
            pairPlay = new Pair();
        }
        return pairPlay;
    }
}
