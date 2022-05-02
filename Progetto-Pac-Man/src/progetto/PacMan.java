/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class PacMan extends Rectangle {

    Color color;
    private char direzione = ' ';

    private int initialX = 100;
    private int initialY = 300;

    public BufferedImage right1;

    Condivisa c;

    PacMan(Color color, Condivisa c) {
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
        getImmaginePacMan();
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

    public char getDirezione() {
        return direzione;
    }

    public void assegnaDirezione(char direzione) {
        if (direzione == 'w' || direzione == 'a' || direzione == 's' || direzione == 'd') {
            this.direzione = direzione;
        } else if (direzione == 'r') {
            resetGame();
        }
    }

    public void getImmaginePacMan() {
        try {
            right1 = ImageIO.read(getClass().getResourceAsStream("/src/textures/PacMan/PacMan_1.png"));
        } catch (Exception e) {

        }
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.x, this.y, this.width, this.height);

        /*
        [Texture in base alla direzione]
        
        BufferedImage image = right1;

        switch (direzione) {
            case 'w':
                image = right1;
                break;
            case 'a':
                image = right1;
                break;
            case 's':
                image = right1;
                break;
            case 'd':
                image = right1;
                break;
            default:
                image = right1;
                break;
        }
        
        TexturePaint tp = new TexturePaint(image, this);
        g.setPaint(tp);
        */

        g.drawImage(image, this.x, this.y, this.width, this.height, null);
    }

}
