/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

/**
 *
 * @author AngelaSoriano 
 * 
 */
public abstract class Phase {
    //Game reference
    protected Game game;
    
    public Phase(Game game){
        this.game = game;
    }
    
    //Each subclass has this as their main player turn loop.
    //Phase will return true on completion, return false if not
    protected abstract boolean executePhase();
    
    //Each phase will have to display cards to players. CLI version **refactor to UI
    //later.
}
