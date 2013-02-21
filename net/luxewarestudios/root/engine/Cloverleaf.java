package net.luxewarestudios.root.engine;

import javax.swing.*;
import java.awt.*;

/**
 *      Root Engine 2D.
 *      Copyright 2013, Created by Felix Angell
 *      All rights reserved.
 *      The
 */
public class Cloverleaf implements Runnable {

    /** Used to draw graphics onto the display */
    private Canvas clCanvas;

    /** This is the display */
    private JFrame frame;

    /** This is run concurrently in the program; it handles our game loop efficeintly */
    private Thread thread;

    /** Defines the size of the display */
    private Dimension size;

    /** 'running' is always set to true to keep the game loop running. Set to false by shutdown() to allow the game
     *  loop to exit cleanly.
     */
    private volatile Boolean running = true;

    /** The width and height of our display */
    private final int width = 800, height = 600;

    /** Defines the title of the display */
    private final String title = "Root2D [prototype]";

    /**
     * Initialises all of our objects; then creates the display
     */
    public Cloverleaf() {
        /** Initialise objects */
        this.clCanvas = new Canvas();
        this.frame = new JFrame();
        this.size = new Dimension(width, height);

        /** Set size of the canvas according to the dimension */
        this.clCanvas.setPreferredSize(size);
        this.clCanvas.setMinimumSize(size);
        this.clCanvas.setMaximumSize(size);

        /** Creates the Display */
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                      // Terminates the program when close is requested
        this.frame.setResizable(false);                                                                                 // Sets the display so that the size of the window cannot be altered
        this.frame.add(clCanvas);                                                                                       // Add the canvas within the display
        this.frame.pack();                                                                                              // Pack the sizes set above
        this.frame.setLocationRelativeTo(null);                                                                         // Centre the display relative to the desktops resoltuion
        this.frame.setVisible(true);                                                                                    // Set the display to be visible
    }

    /**
     *
     */
    public void run() {
        while (!this.running) {
            try {
                this.gameLoop();
            } catch (Exception e) {
                crash("call game loop", e);
            }
        }
    }

    private void gameLoop() {

    }

    private void freeMemory() {

    }

    private void crash(String cause, Exception e) {
        System.out.println("Crash when attempting to " + cause);
        e.printStackTrace();
    }

    public static void main(String[] args) {

    }

}