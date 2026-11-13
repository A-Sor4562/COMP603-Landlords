/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static nz.ac.aut.bqw4562.landlords.app.MainWindow.getMainWindow;
import static nz.ac.aut.bqw4562.landlords.game.Game.getGameInstance;
import static nz.ac.aut.bqw4562.landlords.player.HumanPlayer.createHumanPlayer;
/**
 *
 * @author AngelaSoriano
 */
public class StartGamePanel extends JPanel implements ActionListener{
    private static StartGamePanel startGamePanel;
    private final int TEXT_BOX_LENGTH = 30;
    
    //Following code block generated with the help of copilot
    private final Dimension TEXT_BOX_SIZE = new Dimension(200, 40);
    private final int TEXT_ALIGNMENT = JTextField.CENTER;
    
    
    //All components in this Panel
    //Text Boxes that will hold the player names
    JTextField playerOne = new JTextField(TEXT_BOX_LENGTH);
    JTextField playerTwo = new JTextField(TEXT_BOX_LENGTH);
    JTextField playerThree = new JTextField(TEXT_BOX_LENGTH);
        
    //Label for instruction and player text fields
    JLabel instruction = new JLabel("Enter Player Name in Text Boxes");
    JLabel playerLabelOne = new JLabel("Player One Name:");
    JLabel playerLabelTwo = new JLabel("Player Two Name:");
    JLabel playerLabelThree = new JLabel("Player Three Name:");
    
    //button for Starting Game
    JButton startGame = new JButton("Start Game");
    
    //private constructor
    private StartGamePanel(){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //resize according to TEXT_BOX_SIZE
        playerOne.setPreferredSize(TEXT_BOX_SIZE);
        playerTwo.setPreferredSize(TEXT_BOX_SIZE);
        playerThree.setPreferredSize(TEXT_BOX_SIZE);
        
        startGame.addActionListener(this);
        
        //Adding instruction at the top middle, Copilot helped
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        add(instruction, gbc);
        
        //Adding Text Box Labels, below instruction
        gbc.gridy++; //goes down a row
        gbc.gridwidth = 1; //resets width
        add(playerLabelOne, gbc);
        
        gbc.gridx++; //goes next to previous
        add(playerLabelTwo, gbc);
        
        gbc.gridx++; //goes next to previous
        add(playerLabelThree, gbc);
        
        
        //Adding text fields below text box labels, Copilot helped
        gbc.gridx = 0;
        gbc.gridy++; //goes down a row
        add(playerOne, gbc);
        
        gbc.gridx++; //goes next to previous
        add(playerTwo, gbc);
        
        gbc.gridx++; //goes next to previous
        add(playerThree, gbc);
        
        //Adding start button below text fields middle
        //start gridx at 1 and gridy at 2,  Copilot helped
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        add(startGame, gbc);
      

    }
    
    public static synchronized StartGamePanel getStartGamePanel(){
        if (startGamePanel == null){
            startGamePanel = new StartGamePanel();
        }
        
        return startGamePanel;
    }
    
    //When startGame is pressed, player are created and passed onto a Game class
    @Override
    public void actionPerformed(ActionEvent e) {
        //if any of the text fields are blank, have a popup with error message
        if (playerOne.getText().isBlank() ||
            playerTwo.getText().isBlank() ||
            playerThree.getText().isBlank())
        {
            JOptionPane.showMessageDialog(this, "Missing Player Name(s)",
        "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //starts game instance by creatingHumanPlayers with names from text boxes
        getGameInstance(
        createHumanPlayer(playerOne.getText()),
        createHumanPlayer(playerTwo.getText()),
        createHumanPlayer(playerThree.getText()));
        
        //Player names retrieved using gameInstance
        String playerNames = "Start game with players: \n"
                + getGameInstance().getPlayerOne().getPlayerName() +"\n"
                + getGameInstance().getPlayerTwo().getPlayerName() +"\n"
                + getGameInstance().getPlayerThree().getPlayerName();
        
        //Confirmation message before starting game
        int result = JOptionPane.showConfirmDialog(this, playerNames,
                "Confirm Start Game", JOptionPane.YES_NO_OPTION);
        
        //Handles no or closed dialog
        if (result == 1 || result == -1){
            return;
        }
        else if (result == 0){
            getMainWindow().initializeGamePanel();
            getMainWindow().panelManager.showScreen("GAME");
        }
    }
}
