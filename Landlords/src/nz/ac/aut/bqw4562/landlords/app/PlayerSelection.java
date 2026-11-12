/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.app;

import java.util.ArrayList;
import nz.ac.aut.bqw4562.landlords.game.Game;
import nz.ac.aut.bqw4562.landlords.player.HumanPlayer;
import nz.ac.aut.bqw4562.landlords.player.Player;


/**
 *
 * @author AngelaSoriano
 * Class to select three players by loading or creating. Players are passed onto the game class/instance.
 */
public class PlayerSelection {
    
    private ArrayList<Player> selectedPlayers;
    
    //Function to load player
    protected void playerLoader(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    //Method to createPlayer.
    protected void playerCreator(String name){
        HumanPlayer.createHumanPlayer(name);
    }
    
    protected void selectPlayer(Player player){
        if (selectedPlayers.size() < 3){
            selectedPlayers.add(player);
        }
        else if (selectedPlayers.size() >= 3){
            System.out.println("Three Players already selected.");
        }
    }
    
    protected void deselectPlayer(Player player){
        selectedPlayers.remove(player);
    }
    
    //Passes player to the game instance.
    protected void finishSelection(){
        Game gameInstance = new Game(selectedPlayers.get(0),selectedPlayers.get(1),selectedPlayers.get(3));
    }
}
