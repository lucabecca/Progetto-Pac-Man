/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.*;

public class PacMan extends Rectangle {

    Color color;
    private char direzione = ' ';

    PacMan(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.color = color;
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

    public char getDirezione() {
        return direzione;
    }

    public void assegnaDirezione(char direzione) {
        if (direzione == 'w' || direzione == 'a' || direzione == 's' || direzione == 'd') {
            this.direzione = direzione;
        }
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

}
