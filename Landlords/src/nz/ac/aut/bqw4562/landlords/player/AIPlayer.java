/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.player;

/**
 *
 * @author AngelaSoriano
 */
public class AIPlayer extends Player{
    
    //empty constructor for access protection and method only instantiation
    private AIPlayer(){
        super();
        this.playerType = "AI";
    };
    
    //method only instantiation,
    public AIPlayer createAIPlayer(String playerName){
        AIPlayer createdPlayer = new AIPlayer();
        setPlayerName(playerName);
        return createdPlayer;
    }
    
}
