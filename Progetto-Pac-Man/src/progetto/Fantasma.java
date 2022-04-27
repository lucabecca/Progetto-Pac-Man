/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fantasma extends Rectangle {

    Color color;
    private char direzione = ' ';

    Fantasma(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.color = color;
    }
    
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);
    }
    
}
