/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.controllers;

import java.awt.event.ActionListener;
import javax.swing.JPanel;
import nz.ac.aut.bqw4562.landlords.game.Phase;

/**
 *
 * @author AngelaSoriano
 */
public abstract class PhaseController {
    //Each subclass has a panel and phase they interact with
    protected Phase phase;
    protected JPanel panel;
    
    protected PhaseController(Phase phase, JPanel panel){
        this.phase = phase;
        this.panel = panel;
        
        //listeners
        panel.addPassListener(new PassListener());
        panel.add(new PlayListener());
    }
    
    //Two listeners for passing and playing
    //each controller implements their own logic for this
    abstract class PassListener implements ActionListener{};
    
    abstract class PlayListener implements ActionListener{};
}
