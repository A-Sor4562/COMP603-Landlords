/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.app;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author AngelaSoriano
 * Lots of shared stuff in between the two phases but I'm running out of time
 */
public abstract class PhasePanel extends JPanel{
    //Components of PhasePanels
    public JButton passButton;
    public JButton playButton;
    
    //instruction per phase panel
    JLabel instruction;
    
    GridBagConstraints gbc;
    
    //Default layout
    public PhasePanel(){
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        
    }
    
    public void setUpPanel(){
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
    }
    
    public JButton getPassButton(){
        return passButton;
    }
    
    public JButton getPlayButton(){
        return playButton;
    }
    
}
