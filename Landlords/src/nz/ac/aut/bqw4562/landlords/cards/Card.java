/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.cards;

/**
 *
 * @author AngelaSoriano
 * Card Concept, template for the two different card types.
 */
public abstract class Card{
    
    //methods that must be handled by sub-classes.
    //Makes it easy when needing to print to CLI.
    @Override
    public abstract String toString();
      
}
