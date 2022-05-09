/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadMovimentoPacman extends Thread {

    private PacMan pm;

    private int velocita = 1;

    private int ofsetPixelCollisioni = velocita;

    private Fantasma fan;

    Condivisa c;
    Collisione collisione; 

    ArrayList<Rectangle> muraMappa;

    public ThreadMovimentoPacman(PacMan pm, Fantasma fan, Condivisa c) {
        this.pm = pm;
        this.fan = fan;
        this.c = c;
        this.muraMappa = c.getMuraMappa();
        this.pm.setThreadPac(this);
        collisione = new Collisione(c, pm, velocita);
    }

    @Override
    public void run() {
        while (true) {
            while (c.isGameOver() == false) {
                try {
                    // ControllaCollisioni*() 
                    if (pm.getDirezione() == 'w' && collisione.ControllaCollisioniSopra()) {
                        pm.subY(velocita);
                    } else if (pm.getDirezione() == 'a' && collisione.ControllaCollisioniSinistra()) {
                        pm.subX(velocita);
                    } else if (pm.getDirezione() == 's' && collisione.ControllaCollisioniSotto()) {
                        pm.addY(velocita);
                    } else if (pm.getDirezione() == 'd' && collisione.ControllaCollisioniDestra()) {
                        pm.addX(velocita);
                    }

                    // Controlla l'intersezione con fantasma
                    if (pm.intersects(fan)) {
                        c.setGameOver(true);
                    }

                    sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadMovimentoPacman.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            // Ogni 500ms controlla se GameOver è false
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadMovimentoPacman.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
