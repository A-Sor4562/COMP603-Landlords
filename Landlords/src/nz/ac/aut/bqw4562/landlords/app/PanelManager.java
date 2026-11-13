/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.app;

import java.awt.*;
import javax.swing.JPanel;
import static nz.ac.aut.bqw4562.landlords.app.StartGamePanel.getStartGamePanel;
import static nz.ac.aut.bqw4562.landlords.player.HumanPlayer.createHumanPlayer;

/**
 *
 * @author AngelaSoriano
 * Container for all panels
 */
public class PanelManager extends JPanel{
    private JPanel cards;
    private CardLayout cardLayout;
    

    //constructor
    public PanelManager(){
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        
        setLayout(new BorderLayout());
        
        cards.add(getStartGamePanel(), "START");
        
        add(cards, BorderLayout.CENTER);
    };
    
    public void showScreen(String name){
        cardLayout.show(cards, name);
    };
    
    //method to go to the next panel
    public void nextPanel(){
        cardLayout.next(cards);
    }
    
    //method that initializes and adds the GamePanel to the PanelManager
    public void initializeGamePanel(){
        cards.add(new GamePanel(), "GAME");
    }
}
