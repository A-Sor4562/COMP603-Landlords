/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.util;
import java.util.Random;

/**
 *
 * @author AngelaSoriano
 * Helper class to for random generating
 */
public class RandomGenerator {
    Random random = new Random();
    
    //Function to get a random integer,
    public int randInt(int limit){
            return random.nextInt(limit);
    }
    
    //Function to get a random boolean
    public boolean randBool(){
        return random.nextBoolean();
    }
}
