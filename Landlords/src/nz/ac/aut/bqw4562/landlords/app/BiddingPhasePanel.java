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
public class BiddingPhasePanel extends PhasePanel {
    
    public BiddingPhasePanel(){

        super();
        
        passButton = new JButton("Pass");
        playButton = new JButton("Play");
        
        instruction = new JLabel("Playing Phase : Pass or Play cards?");
        
        setUpPanel();
        
    }
    
    public JButton getPassButton(){
        return passButton;
    }
    
    public JButton getPlayButton(){
        return playButton;
    }
    
}
