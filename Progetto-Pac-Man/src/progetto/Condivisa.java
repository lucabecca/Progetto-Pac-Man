/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Condivisa {

    private boolean GameOver;
    
    private ArrayList<Rectangle> muraMappa= new ArrayList<Rectangle>();

    public Condivisa() {
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

    
    
}
