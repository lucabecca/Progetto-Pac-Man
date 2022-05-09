/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author berto_lorenzo
 */
public class ThreadMovimentoFantasma extends Thread{

    private int velocita = 5;

    private Fantasma fan;
    private int ofsetPixelCollisioni = velocita;
    Condivisa c;
    Collisione collisione;
    private int direzione = -1;

    public ThreadMovimentoFantasma( Fantasma fan, Condivisa c) {
        this.fan = fan;
        this.c = c;
        collisione = new Collisione(c, fan, velocita);
    }

    @Override
    public void run() {
        while (true) {
            while (c.isGameOver() == false) {
                //da fare: quando il fantasmino va in una direzione, continua in quella fino a quando non collide
                try {
                    //quando direzione = -1 deve essere riassegnata, vuol dire che il fantasmino:
                    //- o si è colliso e la direzione è da cambiare
                    //- o è la prima volta che viene eseguito il run
                    if (direzione == -1)
                        direzione = Utility.RandomRange(0, 3);
                    
                    switch(direzione){
                        case 0: 
                            if (collisione.ControllaCollisioniSopra())
                                fan.subY(velocita);
                            else
                                direzione = -1;
                        break;
                        case 1: 
                            if (collisione.ControllaCollisioniSinistra())
                                fan.subX(velocita);
                            else
                                direzione = -1;
                        break;
                        case 2: 
                            if (collisione.ControllaCollisioniSotto())
                                fan.addY(velocita);
                            else
                                direzione = -1;
                        break;
                        case 3: 
                            if (collisione.ControllaCollisioniDestra())
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
