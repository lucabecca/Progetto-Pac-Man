/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Fantasma extends Rectangle {

    private int direzione = 0;

    private int initialX = 310;
    private int initialY = 200;

    int idFan;

    Condivisa c;

    Fantasma(Condivisa c, int idFantasma) {
        this.c = c;
        if (idFantasma >= 1 && idFantasma <= 6) {
            this.width = 50;
            this.height = 50;
            this.idFan = idFantasma;
            resetGame();
        } else {
            c.setGameOver(true);
            System.out.println("idFantasma non presente, inserire un numero tra 1 e 6 come id");
        }
    }

    public void resetGame() {
        this.x = initialX;
        this.y = initialY;
        direzione = 0;
    }

    @Override
    public double getX() {
        return super.getX();
    }

    @Override
    public double getY() {
        return super.getY();
    }

    public void addY(int y) {
        this.y += y;
    }

    public void addX(int x) {
        this.x += x;
    }

    public void subY(int y) {
        this.y = this.y - y;
    }

    void subX(int x) {
        this.x = this.x - x;
    }

    public int getDirezione() {
        return direzione;
    }

    public void assegnaDirezione() {
        direzione = Utility.RandomRange(0, 3);
        System.out.println("La direzione del fantasma è " + direzione);
    }

    public void draw(Graphics g) {
        Image image;
        if (c.isGameOver() == false && c.isWin() == false) {
            switch (direzione) {
                case 'w':
                    image = c.getTexFan(idFan, 3);
                    break;
                case 'a':
                    image = c.getTexFan(idFan, 2);
                    break;
                case 's':
                    image = c.getTexFan(idFan, 1);
                    break;
                case 'd':
                    image = c.getTexFan(idFan, 0);
                    break;
                default:
                    image = c.getTexFan(idFan, 0);
                    break;
            }

            g.drawImage(image, x, y, null);
            //g.setColor(this.color);
            //g.fillRect(this.x, this.y, this.width, this.height);
        }
    }
}
