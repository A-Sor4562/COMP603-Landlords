/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.cards;

/**
 *
 * @author AngelaSoriano
 */
public class Testing {
    
    public static void main(String[] args) {
        
        PlayingCard testing = new PlayingCard(Suit.CLUBS, Rank.THREE);
        
        System.out.println(testing);
        System.out.println(testing.getSuit());
        
    } 
}
