/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.player;

/**
 *
 * @author AngelaSoriano
 */
public class HumanPlayer extends Player{
    
    //constructor for access protection and method only instantiation
    private HumanPlayer(){
        super();
        this.playerType = "Human";
    };
    
    //method only instantiation
    public HumanPlayer createHumanPlayer(String playerName){
        HumanPlayer createdPlayer = new HumanPlayer();
        setPlayerName(playerName);
        return createdPlayer;
    }
}
