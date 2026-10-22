/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

import nz.ac.aut.bqw4562.landlords.cards.Deck;
import nz.ac.aut.bqw4562.landlords.player.*;

/**
 *
 * @author AngelaSoriano
 */
public class Testing {
    public static void main(String[] args) {
        
        Player one = HumanPlayer.createHumanPlayer("Uno");
        Player two = HumanPlayer.createHumanPlayer("Dos");
        Player three =HumanPlayer.createHumanPlayer("Tres");
        
        Game game = new Game(one, two, three);
        
        BiddingPhase testBidPhase = new BiddingPhase(game);
        
        //Prints the dealerDeck from testBidPhase
        System.out.println("Dealer's Deck:");
        testBidPhase.dealerDeck.printDeck();
        
        //Deals initial cards
        testBidPhase.dealInitialCards();
        
        //Prints each players deck
        System.out.println("\n\nPlayer Uno");
        one.getPlayerDeck().printDeck();
        
        System.out.println("\n\nPlayer Two");
        two.getPlayerDeck().printDeck();
        
        System.out.println("\n\nPlayer Three");
        three.getPlayerDeck().printDeck();
    }
}
