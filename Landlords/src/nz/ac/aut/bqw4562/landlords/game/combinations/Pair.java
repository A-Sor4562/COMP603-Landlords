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
    
    //private constructor for method only initialization
    private Pair(){
        super(2, Rank.TWO, false, true);
    }

}
