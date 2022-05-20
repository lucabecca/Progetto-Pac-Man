/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Condivisa {

    private int PuntiPerVincere = 0;

    private boolean GameOver;

    private ArrayList<Rectangle> muraMappa = new ArrayList<Rectangle>();
    private ArrayList<Rectangle> palliniGialli = new ArrayList<Rectangle>();

    private TextureManager txm;

    private int altezzaEntità;
    private int larghezzaEntità;

    private int initialXPacMan;
    private int initialYPacMan;

    public Condivisa(TextureManager txm) {
        this.txm = txm;
        txm.loadPacMan();
        txm.loadFantasma(1);
        txm.loadFantasma(2);
        txm.loadFantasma(3);
        txm.loadFantasma(4);
        txm.loadFantasma(5);
        txm.loadFantasma(6);
        txm.loadPallinoGiallo();

        altezzaEntità = txm.getAltezzaEntità();
        larghezzaEntità = txm.getLarghezzaEntità();

        GameOver = false;
    }

    public boolean isGameOver() {
        return GameOver;
    }

    public void setGameOver(boolean GameOver) {
        this.GameOver = GameOver;
    }

    public ArrayList<Rectangle> getMuraMappa() {
        return muraMappa;
    }

    public void setMuraMappa(ArrayList<Rectangle> muraMappa) {
        this.muraMappa = muraMappa;
    }

    public ArrayList<Rectangle> getPalliniGialli() {
        return palliniGialli;
    }

    public void setPalliniGialli(ArrayList<Rectangle> palliniGialli) {
        this.palliniGialli = palliniGialli;
        PuntiPerVincere = this.palliniGialli.size();
    }

    Image getTexPacMan(int i) {
        return txm.getTexPacMan(i);
    }

    Image getTexFan(int idFan, int i) {
        return txm.getTexFan(idFan, i);
    }

    public int getAltezzaEntità() {
        return altezzaEntità;
    }

    public int getLarghezzaEntità() {
        return larghezzaEntità;
    }

    public void resetGame(PacMan pm) {
        pm.resetGame();
        GameOver = false;
    }

    public Image getTexPalliniGialli() {
         return txm.getTexPalliniGialli();
    }

}
