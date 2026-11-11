/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.Deck;
import static nz.ac.aut.bqw4562.landlords.game.combinations.Pair.pairPlay;
import static nz.ac.aut.bqw4562.landlords.game.combinations.Single.singlePlay;
import static nz.ac.aut.bqw4562.landlords.game.combinations.Trio.trioPlay;

/**
 *
 * @author AngelaSoriano
 * Class responsibility is to find and match card plays
 * Only Single, Pair and Trios are checked at the moment.
 * Bombs and Rockets can trump all plays so will be handled separately
 */
public abstract class CardPlayFinder {
    
    //finds the card play a deck has.
    public static String playFinder(Deck deck){
        if(singlePlay().isValidPlay(deck)){
            return "Single";
        }
        else if(pairPlay().isValidPlay(deck)){
            return "Pair";
        }
        else if(trioPlay().isValidPlay(deck)){
            return "Trio";
        }
        else {return "No match found";}
    }
    
    //Checks a submitted deck
    public static boolean playMatcher(String comboType, Deck deck){
        
        switch(comboType){
            case "Single":
                return singlePlay().isValidPlay(deck);
            case "Pair":
                return pairPlay().isValidPlay(deck);
            case "Trio":
                return trioPlay().isValidPlay(deck);
            default:
                return false;
        }
    }    
}
