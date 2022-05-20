/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author berto_lorenzo
 */
public class ThreadMovimentoFantasma extends Thread{

    private int velocita = 5;

    private Fantasma fan;
    private int offsetPixelCollisioni = velocita;
    Condivisa c;
    Collisione collisione;
    private int direzione = -1;

    public ThreadMovimentoFantasma( Fantasma fan, Condivisa c) {
        this.fan = fan;
        this.c = c;
        collisione = new Collisione(c, fan);
    }

    @Override
    public void run() {
        while (true) {
            while (c.isGameOver() == false && c.isWin() == false) {
                //da fare: quando il fantasmino va in una direzione, continua in quella fino a quando non collide
                try {
                    //quando direzione = -1 deve essere riassegnata, vuol dire che il fantasmino:
                    //- o si è colliso e la direzione è da cambiare
                    //- o è la prima volta che viene eseguito il run
                    if (direzione == -1)
                        direzione = Utility.RandomRange(0, 3);
                    
                    switch(direzione){
                        case 0: 
                            if (collisione.ControllaCollisioni((int) fan.getMinX(), (int) fan.getMinY() - offsetPixelCollisioni, (int) fan.getMaxX(), (int) fan.getMinY() - offsetPixelCollisioni))
                                fan.subY(velocita);
                            else
                                direzione = -1;
                        break;
                        case 1: 
                            if (collisione.ControllaCollisioni((int) fan.getMinX() - offsetPixelCollisioni, (int) fan.getMinY(), (int) fan.getMinX() - offsetPixelCollisioni, (int) fan.getMaxY()))
                                fan.subX(velocita);
                            else
                                direzione = -1;
                        break;
                        case 2: 
                            if (collisione.ControllaCollisioni((int) fan.getMinX(), (int) fan.getMaxY() + offsetPixelCollisioni, (int) fan.getMaxX(), (int) fan.getMaxY() + offsetPixelCollisioni))
                                fan.addY(velocita);
                            else
                                direzione = -1;
                        break;
                        case 3: 
                            if (collisione.ControllaCollisioni((int) fan.getMaxX() + offsetPixelCollisioni, (int) fan.getMaxY(), (int) fan.getMaxX() + offsetPixelCollisioni, (int) fan.getMinY()))
                                fan.addX(velocita);
                            else
                                direzione = -1;
                        break;
                    }
                    // Soluzione non definitiva
                    // Il fantasma deve cambiare direzione solo quando non
                    // non può più muoversi avanti per le pareti.
                    // Da fare dopo collizioni con pareti
                    //fan.assegnaDirezione();
                    
                    sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadMovimentoPacman.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            // Ogni 500ms controlla se GameOver è false
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadMovimentoPacman.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
