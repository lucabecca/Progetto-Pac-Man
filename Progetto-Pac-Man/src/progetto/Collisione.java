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

    public Collisione(Condivisa c, Rectangle type) {
        this.c = c;
        r = type;
    }

    public boolean ControllaCollisioni(int xP1, int yP1, int xP2, int yP2) {

        for (Rectangle mura : c.getMuraMappa()) {
            if (PuntoInRect((int) mura.getMinX(), (int) mura.getMaxY(), (int) mura.getMaxX(), (int) mura.getMinY(), xP1, yP1) || PuntoInRect((int) mura.getMinX(), (int) mura.getMaxY(), (int) mura.getMaxX(), (int) mura.getMinY(), xP2, yP2)) {
                return false;
            }
        }
        return true;
    }

    public boolean PuntoInRect(int xSottoSinista, int ySottoSinistra, int xSopraDestra, int ySopraDestra, int xPunto, int yPunto) {
        if (xPunto > xSottoSinista && xPunto < xSopraDestra && yPunto < ySottoSinistra && yPunto > ySopraDestra) {
            return true;
        }
        return false;
    }

    public boolean ControllaCollisioniIniziale(int xP1, int yP1, int xP2, int yP2) {

        for (Rectangle mura : c.getMuraMappa()) {
            if (PuntoInRectIniziale((int) mura.getMinX(), (int) mura.getMaxY(), (int) mura.getMaxX(), (int) mura.getMinY(), xP1, yP1) || PuntoInRectIniziale((int) mura.getMinX(), (int) mura.getMaxY(), (int) mura.getMaxX(), (int) mura.getMinY(), xP2, yP2)) {
                return false;
            }
        }
        return true;
    }

    public boolean PuntoInRectIniziale(int xSottoSinista, int ySottoSinistra, int xSopraDestra, int ySopraDestra, int xPunto, int yPunto) {
        if (xPunto >= xSottoSinista && xPunto <= xSopraDestra && yPunto <= ySottoSinistra && yPunto >= ySopraDestra) {
            return true;
        }
        return false;
    }

    boolean ControllaCollisioniPallinoGiallo(int xSottoSinista, int ySottoSinista, int xSopraDestra, int ySopraDestra) {
        for (Pallino pallino : c.getPalliniGialli()) {
            if (PuntoInRect((int) xSottoSinista, (int) ySottoSinista, (int) xSopraDestra, (int) ySopraDestra, (int) pallino.getMinX()+30, (int) pallino.getMinY()+30) && pallino.isPassato() == false) {
                c.setPassato(pallino, true);
                return true;
            }
        }

        return false;
    }

}
