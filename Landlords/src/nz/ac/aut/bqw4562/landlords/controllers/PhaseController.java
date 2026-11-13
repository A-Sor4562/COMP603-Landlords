/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import nz.ac.aut.bqw4562.landlords.app.PhasePanel;
import nz.ac.aut.bqw4562.landlords.game.Phase;

/**
 *
 * @author AngelaSoriano
 */
public abstract class PhaseController {
    //Each subclass has a panel and phase they interact with
    protected Phase phase;
    protected PhasePanel panel;
    
    protected PhaseController(Phase phase, PhasePanel panel){
        this.phase = phase;
        this.panel = panel;
        
        panel.getPassButton().addActionListener(new PassListener());
        panel.getPlayButton().addActionListener(new PlayListener());
        
    }
    
    //Two listeners for passing and playing
    //each controller implements their own logic for this
    class PassListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            phase.pass();
        }
    }
    
    class PlayListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            phase.acceptTurn();
        }
    }
}
