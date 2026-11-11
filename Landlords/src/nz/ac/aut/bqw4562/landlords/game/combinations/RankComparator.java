/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.Rank;

/**
 *
 * @author AngelaSoriano
 * Class 
 */
public abstract class RankComparator {
    
    //Method returns true if the rank is first card rank is lower to the second one
    public static boolean isRankLower(Rank firstRank, Rank secondRank){
        if (firstRank.compareTo(secondRank) < 0){
            return true;
        }
        else
        {
            return false;
        }
    
    }
    
}
