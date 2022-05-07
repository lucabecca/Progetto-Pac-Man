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

    ArrayList<Rectangle> muraMappa;

    public ThreadMovimentoPacman(PacMan pm, Fantasma fan, Condivisa c) {
        this.pm = pm;
        this.fan = fan;
        this.c = c;
        this.muraMappa = c.getMuraMappa();
        this.pm.setThreadPac(this);
    }

    @Override
    public void run() {
        while (true) {

            while (c.isGameOver() == false) {

                try {

                    // ControllaCollisioni*() 
                    if (pm.getDirezione() == 'w' && ControllaCollisioniW()) {
                        pm.subY(velocita);
                    } else if (pm.getDirezione() == 'a' && ControllaCollisioniA()) {
                        pm.subX(velocita);
                    } else if (pm.getDirezione() == 's' && ControllaCollisioniS()) {
                        pm.addY(velocita);
                    } else if (pm.getDirezione() == 'd' && ControllaCollisioniD()) {
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

    public boolean ControllaCollisioniW() {
        boolean tmpControlla = true;
        for (Rectangle r : muraMappa) {
            if (PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) pm.getMinX(), (int) pm.getMinY() - ofsetPixelCollisioni) || PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) pm.getMaxX(), (int) pm.getMinY() - ofsetPixelCollisioni)) {
                tmpControlla = false;
                break;
            }
        }
        return tmpControlla;
    }

    public boolean ControllaCollisioniA() {
        boolean tmpControlla = true;
        for (Rectangle r : muraMappa) {
            if (PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) pm.getMinX() - ofsetPixelCollisioni, (int) pm.getMinY()) || PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) pm.getMinX() - ofsetPixelCollisioni, (int) pm.getMaxY())) {
                tmpControlla = false;
                break;
            }
        }
        return tmpControlla;
    }

    public boolean ControllaCollisioniS() {
        boolean tmpControlla = true;
        for (Rectangle r : muraMappa) {
            if (PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) pm.getMinX(), (int) pm.getMaxY() + ofsetPixelCollisioni) || PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) pm.getMaxX(), (int) pm.getMaxY() + ofsetPixelCollisioni)) {
                tmpControlla = false;
                break;
            }
        }
        return tmpControlla;
    }

    public boolean ControllaCollisioniD() {
        boolean tmpControlla = true;
        for (Rectangle r : muraMappa) {
            if (PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) pm.getMaxX() + ofsetPixelCollisioni, (int) pm.getMaxY()) || PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) pm.getMaxX() + ofsetPixelCollisioni, (int) pm.getMinY())) {
                tmpControlla = false;
                break;
            }
        }
        return tmpControlla;
    }

    public boolean PuntoInRect(int xSottoSinista, int ySottoSinistra, int xSopraDestra, int ySopraDestra, int xPunto, int yPunto) {
        if (xPunto > xSottoSinista && xPunto < xSopraDestra && yPunto < ySottoSinistra && yPunto > ySopraDestra) {
            return true;
        }
        return false;
    }
}
