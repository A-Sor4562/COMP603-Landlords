/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.*;

/**
 *
 * @author AngelaSoriano
 * This play is only one card per turn.
 * Can go up from three to Jokers.
 */
public class Single extends CardPlay{
    private static Single singlePlay = null;
    
    //private constructor for method only initialization
    private Single(){
        super(1, Rank.TWO, true, true);
    }

    //Access Method
    public static synchronized Single singlePlay()
    {
        if(singlePlay == null){
            singlePlay = new Single();
        }
        return singlePlay;
    }
}
