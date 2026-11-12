/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.player;

import nz.ac.aut.bqw4562.landlords.cards.Card;
import nz.ac.aut.bqw4562.landlords.cards.Deck;

/**
 * Each player has a deck and a name that can be changed. Two types of Players, Human
 * and AI.
 * @author AngelaSoriano
 */
public abstract class Player {
    
    protected Deck deck;
    protected String name;
    protected String playerType;
    protected Role role; 
    
    //constructor for method only instantiation, 
    //each player has only one deck, don't have roles at the beggining
    protected Player(){
        this.deck = new Deck();
        this.role = null;
    } 
    
    public void setPlayerName(String changeName){
        this.name = changeName;
    }
    
    public String getPlayerName(){
        return name;
    }
    
    public String getPlayerType(){
        return this.playerType;
    }
    
    public Deck getPlayerDeck(){
        return this.deck;
    }
    
    //Role methods
    //Set player as Landlord
    public void setAsLandlord(){
        this.role = Role.LANDLORD;
    }
    
    //Set player as Peasant
    public void setAsPeasant(){
        this.role = Role.PEASANT;
    }
    
    //Get player role
    public Role getRole(){
        return this.role;
    }
    
    //Play card, using Deck's remove fuction.
    public Card playCard(int i){
        return this.deck.removeCard(i);
    }
}
