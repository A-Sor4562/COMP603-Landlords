/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

import nz.ac.aut.bqw4562.landlords.cards.Deck;
import nz.ac.aut.bqw4562.landlords.player.Player;
import nz.ac.aut.bqw4562.landlords.util.*;

/**
 *
 * @author AngelaSoriano 
 * 
 */
public abstract class Phase {
    //Game reference
    protected Game game;
    
    protected Phase(Game game){
        this.game = game;
    }
    
    //Phase start/setup
    protected abstract Phase startPhase(Game game);
    
    //Each subclass has this as their main player turn loop.**Re-do later

    protected abstract boolean executePhase();
    

    
}
