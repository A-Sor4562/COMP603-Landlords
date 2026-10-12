/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.player;

import nz.ac.aut.bqw4562.landlords.cards.Deck;

/**
 * Each player has a deck and a name that can be changed. Two types of Players, Human
 * and AI.
 * @author AngelaSoriano
 */
public abstract class Player {
    
    private Deck deck;
    private String name;
    
    //private constructor, each player has only one deck
    private Player(){
    }
    
}
