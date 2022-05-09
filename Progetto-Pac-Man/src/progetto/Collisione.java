/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto;

import java.awt.Rectangle;

/**
 *
 * @author Giordano
 */
public class Collisione {
    private Condivisa c;
    private Rectangle r; 
    private int offsetPixelCollisioni;
    
    public Collisione(Condivisa c, Rectangle type, int velocita){
        this.c = c;
        r = type;
        offsetPixelCollisioni = velocita;
    }
    
    public boolean ControllaCollisioniSopra() {
        boolean tmpControlla = true;
        for (Rectangle r : c.getMuraMappa()) {
            if (PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) this.r.getMinX(), (int) this.r.getMinY() - offsetPixelCollisioni) || PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) this.r.getMaxX(), (int) this.r.getMinY() - offsetPixelCollisioni)) {
                tmpControlla = false;
                break;
            }
        }
        return tmpControlla;
    }

    public boolean ControllaCollisioniSinistra() {
        boolean tmpControlla = true;
        for (Rectangle r : c.getMuraMappa()) {
            if (PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) this.r.getMinX() - offsetPixelCollisioni, (int) this.r.getMinY()) || PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) this.r.getMinX() - offsetPixelCollisioni, (int) this.r.getMaxY())) {
                tmpControlla = false;
                break;
            }
        }
        return tmpControlla;
    }

    public boolean ControllaCollisioniSotto() {
        boolean tmpControlla = true;
        for (Rectangle r : c.getMuraMappa()) {
            if (PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) this.r.getMinX(), (int) this.r.getMaxY() + offsetPixelCollisioni) || PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) this.r.getMaxX(), (int) this.r.getMaxY() + offsetPixelCollisioni)) {
                tmpControlla = false;
                break;
            }
        }
        return tmpControlla;
    }

    public boolean ControllaCollisioniDestra() {
        boolean tmpControlla = true;
        for (Rectangle r : c.getMuraMappa()) {
            if (PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) this.r.getMaxX() + offsetPixelCollisioni, (int) this.r.getMaxY()) || PuntoInRect((int) r.getMinX(), (int) r.getMaxY(), (int) r.getMaxX(), (int) r.getMinY(), (int) this.r.getMaxX() + offsetPixelCollisioni, (int) this.r.getMinY())) {
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
