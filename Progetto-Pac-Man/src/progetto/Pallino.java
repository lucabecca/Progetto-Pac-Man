/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Luca
 */
public class Pallino extends Rectangle {

    private boolean passato;

    Condivisa c;

    Pallino(Condivisa c, int posX, int posY, int AltezzaEntitaMappa, int LarghezzaEntitàMappa) {
        this.x = posX;
        this.y = posY;
        this.height = AltezzaEntitaMappa;
        this.width = LarghezzaEntitàMappa;
        passato = false;
        this.c = c;
    }

    public boolean isPassato() {
        return passato;
    }

    public void setPassato(boolean b) {
        passato = b;
    }

    public void draw(Graphics g) {
        if (passato == false) {
            g.drawImage(c.getTexPalliniGialli(), this.x, this.y, null);
        }
    }

}
