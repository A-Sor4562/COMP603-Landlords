/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.util;

import java.util.Scanner;
import nz.ac.aut.bqw4562.landlords.player.Player;

/**
 *
 * @author AngelaSoriano
 * Helper/Utility Class that asks for user input and displays prompts from different classes
 * 
 */
public class UserInputOutput {
    Scanner scan;
    
    public UserInputOutput(){
        scan = new Scanner(System.in);
    }
    
    /*
        Methods I want
        Display prompt - takes in string and output the prompt onto console. Asks player by name
        User input - asks for user input. **Needs error handling later for different input types
    */
    
    public void displayPrompt(String prompt, Player player){
        System.out.println(player.getPlayerName() + ": " + prompt + "?");
    }
    
    //Currently int for now, **needs error handling
    public int askUserInput(){
        return scan.nextInt();
    }
}
