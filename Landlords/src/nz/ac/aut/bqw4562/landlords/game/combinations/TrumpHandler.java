/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game.combinations;

import nz.ac.aut.bqw4562.landlords.cards.Deck;
import static nz.ac.aut.bqw4562.landlords.game.combinations.Bomb.bombPlay;
import static nz.ac.aut.bqw4562.landlords.game.combinations.Rocket.rocketPlay;

/**
 *
 * @author AngelaSoriano
 * Class handles trumps, ie. bombs and rockets
 */
public class TrumpHandler {
    
    //Method to check if the deck is a rocket, returns boolean
    public boolean rocketChecker(Deck deck){
        return rocketPlay().isValidPlay(deck);
    }
    
    public boolean bombChecker(Deck deck){
        return bombPlay().isValidPlay(deck);
    }
    
    public boolean isATrump(Deck deck){
        if (rocketChecker(deck) || bombChecker(deck)){
            return true;
        }
        else {return false;}
    }
}
