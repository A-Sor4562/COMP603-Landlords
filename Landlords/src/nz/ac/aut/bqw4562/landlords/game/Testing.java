/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

import java.util.Scanner;
import nz.ac.aut.bqw4562.landlords.cards.Deck;
import nz.ac.aut.bqw4562.landlords.player.*;

/**
 *
 * @author AngelaSoriano
 */
public class Testing {
    public static void main(String[] args) {
        //Scanner for testing
        Scanner scan = new Scanner(System.in);
        
        Player one = HumanPlayer.createHumanPlayer("Uno");
        Player two = HumanPlayer.createHumanPlayer("Dos");
        Player three = HumanPlayer.createHumanPlayer("Tres");
        
        Game game = new Game(one, two, three);
        
        BiddingPhase testBidPhase = new BiddingPhase(game);
        
        //Prints the dealerDeck from testBidPhase
        System.out.println("Dealer's Deck:");
        testBidPhase.dealerDeck.printDeck();
        
        //Deals initial cards
        testBidPhase.dealInitialCards();
        
//        //Prints each players deck
//        System.out.println("\n\nPlayer Uno");
//        one.getPlayerDeck().printDeck();
//        
//        System.out.println("\n\nPlayer Two");
//        two.getPlayerDeck().printDeck();
//        
//        System.out.println("\n\nPlayer Three");
//        three.getPlayerDeck().printDeck();
        
        //conduct the bidding phase
        testBidPhase.conductBidding();
        
        //Prints out all roles
        System.out.println(one.getRole());
        System.out.println(two.getRole());
        System.out.println(three.getRole());
        
        //Prints each players deck size
        System.out.println("\n\nPlayer Uno");
        System.out.println(one.getPlayerDeck().deckSize());
        
        System.out.println("\n\nPlayer Two");
        System.out.println(two.getPlayerDeck().deckSize());
        
        System.out.println("\n\nPlayer Three");
        System.out.println(three.getPlayerDeck().deckSize());
        
        //Testing PlayPhase
        PlayPhase playPhase = new PlayPhase(game);
        playPhase.askPlayerAction();
        
        System.out.println("What the heck");
        

    }
}
