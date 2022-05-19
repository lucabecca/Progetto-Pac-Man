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

    private int offsetPixelCollisioni = velocita;

    private Fantasma fan1;

    Condivisa c;

    Collisione collisione;

    ArrayList<Rectangle> muraMappa;

    public ThreadMovimentoPacman(PacMan pm, Fantasma fan1, Condivisa c) {
        this.pm = pm;
        this.fan1 = fan1;
        this.c = c;
        this.muraMappa = c.getMuraMappa();
        this.pm.setThreadPac(this);
        collisione = new Collisione(c, pm);
        this.pm.setPosizione();
    }

    public int getOffsetPixelCollisioni() {
        return offsetPixelCollisioni;
    }

    @Override
    public void run() {
        while (true) {
            while (c.isGameOver() == false) {
                try {
                    // ControllaCollisioni*() 
                    if (pm.getDirezione() == 'w' && collisione.ControllaCollisioni((int) pm.getMinX(), (int) pm.getMinY() - offsetPixelCollisioni, (int) pm.getMaxX(), (int) pm.getMinY() - offsetPixelCollisioni)) {
                        pm.subY(velocita);
                    } else if (pm.getDirezione() == 'a' && collisione.ControllaCollisioni((int) pm.getMinX() - offsetPixelCollisioni, (int) pm.getMinY(), (int) pm.getMinX() - offsetPixelCollisioni, (int) pm.getMaxY())) {
                        pm.subX(velocita);
                    } else if (pm.getDirezione() == 's' && collisione.ControllaCollisioni((int) pm.getMinX(), (int) pm.getMaxY() + offsetPixelCollisioni, (int) pm.getMaxX(), (int) pm.getMaxY() + offsetPixelCollisioni)) {
                        pm.addY(velocita);
                    } else if (pm.getDirezione() == 'd' && collisione.ControllaCollisioni((int) pm.getMaxX() + offsetPixelCollisioni, (int) pm.getMaxY(), (int) pm.getMaxX() + offsetPixelCollisioni, (int) pm.getMinY())) {
                        pm.addX(velocita);
                    }

                    // Controlla l'intersezione con fantasma
                    if (pm.intersects(fan1)) {
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
