/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.cards;

/**
 *
 * @author AngelaSoriano
 */
public class Joker extends Card{
    
    private final String colour;
    private final String rank = "Joker";
    
    /*
    Since there are only two Jokers it's easier to make two methods handling each one
    private modifier so only the methods are able to make joker cards.
    protected modifier so no other part of program can use method.
    I think it will be easier to handle during new deck generation
    This also makes sure only red and black jokers are made.
    */
    
    //protected constructor with colour for access protection
    protected Joker(String colour){
        this.colour = colour;
    }
    
    protected static Joker redJoker(){
        Joker redJoker = new Joker("Red");
        return redJoker;
    }
    
    protected static Joker blackJoker(){
        Joker blackJoker = new Joker("Black");
        return blackJoker;
    }
    
    //Single getter only as they are both jokers and the colour is the only one used in game logic
    public String getJoker(){
        return this.colour + this.rank;
    }
    
    //Easier printing for CLI, format is Colour Joker
    @Override
    public String toString() {
        return this.colour + " " + this.rank;
    }
    
}
