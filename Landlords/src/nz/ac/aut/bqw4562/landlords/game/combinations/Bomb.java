/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.*;



/**
 *
 * @author AngelaSoriano
 * Four of the same rank per turn
 * Goes from three to two
 * No jokers allowed
 */
public class Bomb extends CardPlay{
    private static Bomb bombPlay = null;
    
    //private constructor for method only initialization
    private Bomb(){
        super(4, Rank.THREE, false, true);
    }    
    
    //Access Method
    public static synchronized Bomb bombPlay(){
        if(bombPlay == null){
            bombPlay = new Bomb();
        }
        
        return bombPlay;
    }
}
