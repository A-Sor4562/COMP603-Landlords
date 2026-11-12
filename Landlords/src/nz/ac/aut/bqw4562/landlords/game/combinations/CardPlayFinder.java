/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.Deck;
import static nz.ac.aut.bqw4562.landlords.game.combinations.Bomb.bombPlay;
import static nz.ac.aut.bqw4562.landlords.game.combinations.Pair.pairPlay;
import static nz.ac.aut.bqw4562.landlords.game.combinations.Rocket.rocketPlay;
import static nz.ac.aut.bqw4562.landlords.game.combinations.Single.singlePlay;
import static nz.ac.aut.bqw4562.landlords.game.combinations.Trio.trioPlay;

/**
 *
 * @author AngelaSoriano
 * Class responsibility is to find and match card plays
 */
public class CardPlayFinder {
    
    public CardPlayFinder(){
        
    };
    
    //finds the card play a deck has.
    public String playFinder(Deck deck){
        if(singlePlay().isValidPlay(deck)){
            return "Single";
        }
        else if(pairPlay().isValidPlay(deck)){
            return "Pair";
        }
        else if(trioPlay().isValidPlay(deck)){
            return "Trio";
        }
        else if(bombPlay().isValidPlay(deck)){
            return "Bomb";
        }
        else if (rocketPlay().isValidPlay(deck)){
            return "Rocket";
        }
        else {return "No match found";}
    }
    
    //Checks a submitted deck
    public boolean playMatcher(String comboType, Deck deck){
        
        switch(comboType){
            case "Single":
                return singlePlay().isValidPlay(deck);
            case "Pair":
                return pairPlay().isValidPlay(deck);
            case "Trio":
                return trioPlay().isValidPlay(deck);
            case "Rocket":
                return rocketPlay().isValidPlay(deck);
            default:
                return false;
        }
    }
}
