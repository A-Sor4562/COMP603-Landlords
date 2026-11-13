/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.app;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author AngelaSoriano
 */

public class PlayPhasePanel extends JPanel implements ActionListener{
    
    //Components of Panel
    private static JButton passButton = new JButton("Pass"); //button for passing
    private static JButton playButton = new JButton("Play"); //button for playing
    
    private JLabel instruction = new JLabel("Playing Phase : Pass or Play cards?");
    
    public PlayPhasePanel(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        //Display instruction along the top
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.NORTH;
        add(instruction, gbc);
        
        //Display action buttons along below instructions
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        add(passButton, gbc);
        
        //add the bidButton next to it
        gbc.gridx = 1;
        add(playButton, gbc);
        
        //listener for buttons
        passButton.addActionListener(this);
        playButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == passButton){
            //insert action
        }
        
        if(source == playButton){
            //insert action
        }
    }
    
    
}
