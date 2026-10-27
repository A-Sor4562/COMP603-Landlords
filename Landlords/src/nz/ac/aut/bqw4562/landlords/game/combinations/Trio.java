/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.*;

/**
 *
 * @author AngelaSoriano
 * Three cards of the same rank
 * Goes from three to two
 * No jokers allowed
 */
public class Trio extends CardPlay{
    
    //private constructor for method only initialization
    private Trio(){
        super(3, Rank.TWO, false, true);
    }

}
