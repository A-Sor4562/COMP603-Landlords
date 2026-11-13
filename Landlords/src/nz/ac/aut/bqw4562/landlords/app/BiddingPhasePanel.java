/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author AngelaSoriano
 * Panel that appears when entering bidding phase
 * has a row of action button at the bottom
 */
public class BiddingPhasePanel extends JPanel implements ActionListener{
    //Components of Panel
    private static JButton passButton = new JButton("Pass"); //button for passing
    private static JButton bidButton = new JButton("Bid"); //button for bidding
    private JLabel instruction = new JLabel("Bidding Phase: Pass or Bid?");
    
    public BiddingPhasePanel(){
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
        add(bidButton, gbc);
        
        //listener for buttons
        passButton.addActionListener(this);
        bidButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == passButton){
            //insert action
            
        }
        
        if(source == bidButton){
            //insert action
        }
    }
    
    
}
