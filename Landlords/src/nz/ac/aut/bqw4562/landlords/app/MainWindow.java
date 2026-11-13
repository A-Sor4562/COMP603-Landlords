/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nz.ac.aut.bqw4562.landlords.app;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import nz.ac.aut.bqw4562.landlords.game.Game;

/**
 *
 * @author AngelaSoriano
 * Class is the main window which holds the different JPanels
 */
public class MainWindow extends JFrame{
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screenSize = kit.getScreenSize();
    private final int WIDTH = screenSize.width/2;
    private final int HEIGHT = screenSize.height/2;
    private static MainWindow main;
    private static Game game;
    final PanelManager panelManager = new PanelManager();

    
    //constructor
    private MainWindow(){
        this.setTitle("COMP603 Project Landlords");
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        add(panelManager);
    }
    
    //method to go to the next panel in panelManager
    public static void nextPanel(){
        getMainWindow().panelManager.nextPanel();
    }
    
    public static synchronized MainWindow getMainWindow(){
        if (main == null){
            main = new MainWindow();
        }
        return main;
    }
    
    public static void initializeGamePanel(){
        main.panelManager.initializeGamePanel();
    }
    
    //Method to call when launching program
    public static void start(){
        getMainWindow().panelManager.showScreen("START");    
    }
    
    public static void main(String[] args) {
        start();
    }
}
