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
    private char direzionePrec = ' ';

    private int initialX = 100;
    private int initialY = 300;

    public BufferedImage right1;

    Condivisa c;

    private ThreadMovimentoPacman ThreadPac;

    PacMan(Color color, Condivisa c) {
        this.c = c;
        this.width = 50;
        this.height = 50;
        this.color = color;
        resetGame();
    }

    public void setThreadPac(ThreadMovimentoPacman ThreadPac) {
        this.ThreadPac = ThreadPac;
    }

    public void resetGame() {
        this.x = initialX;
        this.y = initialY;
        direzione = ' ';
        direzionePrec = ' ';
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

    public char getDirezionePrec() {
        return direzionePrec;
    }

    public void assegnaDirezione(char direzione) {
        boolean controlla = false;
        switch (direzione) {
            case 'w':
                if (ThreadPac.ControllaCollisioniW()) {
                    controlla = true;
                }
                break;
            case 'a':
                if (ThreadPac.ControllaCollisioniA()) {
                    controlla = true;
                }
                break;
            case 's':
                if (ThreadPac.ControllaCollisioniS()) {
                    controlla = true;
                }
                break;
            case 'd':
                if (ThreadPac.ControllaCollisioniD()) {
                    controlla = true;
                }
                break;
            case 'r':
                resetGame();
                break;
            default:
                System.out.println("Tasto non riconosciuto");
                break;

        }
        if (controlla) {
            this.direzione = direzione;
            this.direzionePrec = this.direzione;
        } else {
            this.direzione = this.direzionePrec;
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
        //Image i = TextureManager.getTexture(1);
        //g.drawImage(i, x, y, null);
        g.fillRect(this.x, this.y, this.width, this.height);
    }

}
