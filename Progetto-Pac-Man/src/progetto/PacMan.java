/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.*;

public class PacMan extends Rectangle {

    private char direzione = ' ';
    private char direzionePrec = ' ';

    private int initialX = 10;
    private int initialY = 33;

    private int contatoreTextureAperto = 0;
    private int contatoreTextureChiuso = 0;

    Condivisa c;

    private ThreadMovimentoPacman ThreadPac;

    PacMan(Condivisa c) {
        this.c = c;
        this.width = 50;
        this.height = 50;

        resetGame();
    }

    public void setPosizione() {
        boolean collide = true;
        do {
            if (ThreadPac.collisione.ControllaCollisioni(initialX, initialY + 50, initialX + 50, initialY)) {
                collide = false;
            } else {
                initialX++;
                if (ThreadPac.collisione.ControllaCollisioni(initialX, initialY + 50, initialX + 50, initialY)) {
                    collide = false;
                } else {
                    initialY++;
                }
            }
        } while (collide == true);
        resetGame();
    }

    public void resetGame() {
        direzione = ' ';
        direzionePrec = ' ';
        this.x = initialX;
        this.y = initialY;
    }

    public void setThreadPac(ThreadMovimentoPacman ThreadPac) {
        this.ThreadPac = ThreadPac;
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
        int numeroControlloMossa = 10;
        boolean controlla = false;
        switch (direzione) {
            case 'w':
                if (ThreadPac.collisione.ControllaCollisioni((int) this.getMinX(), (int) this.getMinY() - ThreadPac.getOffsetPixelCollisioni(), (int) this.getMaxX(), (int) this.getMinY() - ThreadPac.getOffsetPixelCollisioni())) {
                    controlla = true;
                }
                break;
            case 'a':
                if (ThreadPac.collisione.ControllaCollisioni((int) this.getMinX() - ThreadPac.getOffsetPixelCollisioni(), (int) this.getMinY(), (int) this.getMinX() - ThreadPac.getOffsetPixelCollisioni(), (int) this.getMaxY())) {
                    controlla = true;
                }
                break;
            case 's':
                if (ThreadPac.collisione.ControllaCollisioni((int) this.getMinX(), (int) this.getMaxY() + ThreadPac.getOffsetPixelCollisioni(), (int) this.getMaxX(), (int) this.getMaxY() + ThreadPac.getOffsetPixelCollisioni())) {
                    controlla = true;
                }
                break;

            case 'd':
                if (ThreadPac.collisione.ControllaCollisioni((int) this.getMaxX() + ThreadPac.getOffsetPixelCollisioni(), (int) this.getMaxY(), (int) this.getMaxX() + ThreadPac.getOffsetPixelCollisioni(), (int) this.getMinY())) {
                    controlla = true;
                }
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

    public void draw(Graphics g) {
        int texture = 0;
        // Velocita chiusura e apertura bocca (+ grande = + lento)
        int nTextureDiSeguito = 8;

        if (c.isGameOver() == false && c.isWin() == false) {
            Image image;
            switch (direzione) {
                case 'w':
                    if (contatoreTextureAperto >= nTextureDiSeguito) {
                        texture = 0;
                        if (contatoreTextureChiuso >= nTextureDiSeguito) {
                            contatoreTextureAperto = 0;
                            contatoreTextureChiuso = 0;
                        } else {
                            contatoreTextureChiuso++;
                        }
                    } else {
                        contatoreTextureAperto++;
                        texture = 4;
                    }
                    break;
                case 'a':
                    if (contatoreTextureAperto >= nTextureDiSeguito) {
                        texture = 0;
                        if (contatoreTextureChiuso >= nTextureDiSeguito) {
                            contatoreTextureAperto = 0;
                            contatoreTextureChiuso = 0;
                        } else {
                            contatoreTextureChiuso++;
                        }
                    } else {
                        contatoreTextureAperto++;
                        texture = 3;
                    }
                    break;
                case 's':
                    if (contatoreTextureAperto >= nTextureDiSeguito) {
                        texture = 0;
                        if (contatoreTextureChiuso >= nTextureDiSeguito) {
                            contatoreTextureAperto = 0;
                            contatoreTextureChiuso = 0;
                        } else {
                            contatoreTextureChiuso++;
                        }
                    } else {
                        contatoreTextureAperto++;
                        texture = 2;
                    }
                    break;
                case 'd':
                    if (contatoreTextureAperto >= nTextureDiSeguito) {
                        texture = 0;
                        if (contatoreTextureChiuso >= nTextureDiSeguito) {
                            contatoreTextureAperto = 0;
                            contatoreTextureChiuso = 0;
                        } else {
                            contatoreTextureChiuso++;
                        }
                    } else {
                        contatoreTextureAperto++;
                        texture = 1;
                    }
                    break;
                default:
                    texture = 0;
                    break;
            }
            image = c.getTexPacMan(texture);
            g.drawImage(image, x, y, null);
        }

        //g.setColor(this.color);
        //g.fillRect(this.x, this.y, this.width, this.height);
    }

}
