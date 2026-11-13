/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.game;

import nz.ac.aut.bqw4562.landlords.cards.Deck;
import nz.ac.aut.bqw4562.landlords.cards.PlayingCard;
import nz.ac.aut.bqw4562.landlords.cards.Rank;
import nz.ac.aut.bqw4562.landlords.game.combinations.CardPlayFinder;
import nz.ac.aut.bqw4562.landlords.game.combinations.TrumpHandler;

/**
 *
 * @author AngelaSoriano
 */
public class PlayPhase extends Phase{
    private String comboPlayed;
    private CardPlayFinder comboChecker;
    private TrumpHandler trumpChecker;
    private boolean previousPlay = false;

    private PlayPhase(Game game) {
        super(game);
        
        comboChecker = new CardPlayFinder();
        trumpChecker = new TrumpHandler();
        
        resetPassCounter();
        
    }
    
    //method where player submits their cards
    public Deck playerCardSubmit(){
        
        //Deck to hold which cards are being played.
        Deck cardsPlayed = new Deck();
        
        //game.getCurrentPlayer().playCard();
        return cardsPlayed;
    }
    
    //Previous plays are stored in dealerDeck, if it's empty there is no play,
    protected void checkForPreviousPlay(){
        previousPlay = !(game.getDealerDeck().isDeckEmpty());
    }
    
    //clears dealerDeck then deals all the selected cards into dealerDeck
    protected void playAccepted(Deck selectedCards){
        clearDealerDeck();
        while(!selectedCards.isDeckEmpty()){
                selectedCards.dealCard(game.getDealerDeck());
            }
        
    }
    
    //Method for no previous play, play is accepted and combo is found
    protected boolean noPreviousPlay(Deck selectedCards){
        findCombo(selectedCards);
        playAccepted(selectedCards);
        return true;
        
    }
    
    //method for having a previous play, checks if the selected cards matches the combo that is being played
    //also checks if the rank is higher or it's a trump, returns true if play was accepted.
    protected boolean yesPreviousPlay(Deck selectedCards){
        //if the combo matches and the rank is higher accept play
        if(isComboMatching(selectedCards) && compareRank(selectedCards)){
            playAccepted(selectedCards);
            return true;
        }
        
        //if selectedCards is a trump and rocket hasn't been in play yet
        if(isATrump(selectedCards)){
            playAccepted(selectedCards);
            return true;
        }
        
        return false;
    }
    
    //method returns card to player if it's invalid **needs to be implemented.
    protected void playDenied(){
        
    }
    
    //checks if combo is matching
    protected boolean isComboMatching(Deck selectedCards){
        return comboChecker.playMatcher(comboPlayed, selectedCards);
    }
    
    //checks if trump play, return true if it is, false if not, sets combo type as well
    protected boolean isATrump(Deck selectedCards){
        //checks if deck is rocket, sets the combo type to Rocket and accepts the play
        if (trumpChecker.rocketChecker(selectedCards)){
            comboPlayed = "Rocket";
            playAccepted(selectedCards);
            return true;
        }
                    
        //if play is bomb, accept play, return true
        if (trumpChecker.bombChecker(selectedCards)){
            comboPlayed = "Bomb";
            playAccepted(selectedCards);
            return true;
        }
        
        return false;
    }
    
    //method for finding combo
    protected void findCombo(Deck deck){
        comboPlayed = comboChecker.playFinder(deck);
    }
    
    //returns true if selected cards are higher than dealerDeck cards
    protected boolean compareRank(Deck selectedCards){
        try{
            Rank selectedRank = ((PlayingCard)selectedCards.getCard(0)).getRank();
            Rank dealerRank = ((PlayingCard)game.getDealerDeck().getCard(0)).getRank();
        
                if (selectedRank.compareTo(dealerRank) > 0){
                    return true;
                }
                else{
                    return false;
                }
        } catch (ClassCastException e){
            return false;
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
        catch (NullPointerException e){
            return false;
        }
    }
    
    @Override
    protected boolean checkPassCounter(){
        //if two or more players pass, the previous play is cleared and the comboPlayed is reset
        if(passCounter >= 2){
            
            game.getDealerDeck().clearDeck();
            comboPlayed = null;
            
        }
        return true;
    }
    
    @Override
    protected Phase startPhase(Game game) {
        return new PlayPhase(game);
    }
    
    @Override
    protected boolean executePhase(){
        
        return isPhaseFinished();
    }
    
    //method to check if play is valid **Not implemented
    protected void checkValidPlay(Deck deck){};
    
    @Override
    public void acceptTurn(){
        //everytime a player plays, the passcounter is reset
        resetPassCounter();
        //player will submit cards which will be checked
        checkValidPlay(playerCardSubmit());
    }
    
    //Checks if the currentPlayers deck is empty
    @Override
    protected boolean isPhaseFinished(){
        return game.getCurrentPlayer().getPlayerDeck().isDeckEmpty();
    }
    
    
}
