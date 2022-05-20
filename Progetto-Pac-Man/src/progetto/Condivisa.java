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

    private int Punti = 0;

    private boolean GameOver;

    private ArrayList<Rectangle> muraMappa = new ArrayList<Rectangle>();
    private ArrayList<Pallino> palliniGialli = new ArrayList<Pallino>();

    private TextureManager txm;

    private int altezzaEntità;
    private int larghezzaEntità;

    private int initialXPacMan;
    private int initialYPacMan;
    private boolean Win;

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
        Win = false;
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

    public ArrayList<Pallino> getPalliniGialli() {
        return palliniGialli;
    }

    public void setPalliniGialli(ArrayList<Pallino> palliniGialli) {
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

    public int getPuntiPerVincere() {
        return PuntiPerVincere;
    }

    public void setPuntiPerVincere(int PuntiPerVincere) {
        this.PuntiPerVincere = PuntiPerVincere;
    }

    public int getPunti() {
        return Punti;
    }

    public void setPunti(int Punti) {
        this.Punti = Punti;
    }

    public boolean isWin() {
        return Win;
    }

    public void setWin(boolean Win) {
        this.Win = Win;
    }

    public void aggiungiPunto() {
        if (Punti < PuntiPerVincere - 1) {
            Punti++;
        } else {
            System.out.println("lasjfdlkasdf");
            Win = true;
        }
    }

    public boolean isPassato(Pallino pallino) {
        return pallino.isPassato();
    }

    public void setPassato(Pallino pallino, boolean b) {
        pallino.setPassato(b);
    }

}
