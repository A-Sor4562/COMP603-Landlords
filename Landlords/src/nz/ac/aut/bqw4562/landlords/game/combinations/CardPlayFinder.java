/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.Deck;

/**
 *
 * @author AngelaSoriano
 * Class responsibility is to match a deck into a card play
 * Only Single, Pair and Trios are checked at the moment.
 * Bombs and Rockets can trump all plays so will be handled separately
 */
public class CardPlayFinder {
    
    //finds the card play a deck has.
    public static String CardPlayFinder(Deck deck){
        if(SingleChecker(deck)){
            return "Single";
        }
        else if(PairChecker(deck)){
            return "Pair";
        }
        else if(TrioChecker(deck)){
            return "Trio";
        }
        else {return "No match found";}
    }
    
    //Checks a submitted deck
    public static boolean CardPlayMatches(String comboType, Deck deck){
        
        switch(comboType){
            case "Single":
                return SingleChecker(deck);
            case "Pair":
                return PairChecker(deck);
            case "Trio":
                return TrioChecker(deck);
            default:
                return false;
        }
    }    
}
