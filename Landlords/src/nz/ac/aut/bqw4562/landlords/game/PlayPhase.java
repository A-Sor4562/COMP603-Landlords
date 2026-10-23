/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

import nz.ac.aut.bqw4562.landlords.player.Player;

/**
 *
 * @author AngelaSoriano
 */
public class PlayPhase extends Phase{

    public PlayPhase(Game game) {
        super(game);
        
    }
    @Override
    protected boolean executePhase(){
        
        /*
        Game play loop. Ask player for card. Check if valid. Go to next player
        */
        while(true){
            
        }
        
        return false;
    }
    
    //Method to ask for card
    public void askForCard(Player player){
        /*
        Prompts are pass, play card or hint
        Player deals card.
        */
    }
}
