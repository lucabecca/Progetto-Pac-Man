/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Fantasma extends Rectangle {

    Color color;
    private int direzione = ' ';

    private int initialX = 400;
    private int initialY = 300;

    Condivisa c;

    Fantasma(Color color, Condivisa c) {
        this.c = c;
        this.width = 50;
        this.height = 50;
        this.color = color;
        resetGame();
    }

    public void resetGame() {
        this.x = initialX;
        this.y = initialY;
        direzione = ' ';
        c.setGameOver(false);
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
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

}
