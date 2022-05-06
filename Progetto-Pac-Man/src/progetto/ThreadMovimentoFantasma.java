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

    private int velocita = 1;

    private Fantasma fan;

    Condivisa c;

    public ThreadMovimentoFantasma( Fantasma fan, Condivisa c) {
        this.fan = fan;
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {

            while (c.isGameOver() == false) {
                try {

                    if (fan.getDirezione() == 0) {
                        //w
                        fan.subY(velocita);
                    } else if (fan.getDirezione() == 1) {
                        //a
                        fan.subX(velocita);
                    } else if (fan.getDirezione() == 2) {
                        //s
                        fan.addY(velocita);
                    } else if (fan.getDirezione() == 3) {
                        //d
                        fan.addX(velocita);
                    }

                    // Soluzione non definitiva
                    // Il fantasma deve cambiare direzione solo quando non
                    // non può più muoversi avanti per le pareti.
                    // Da fare dopo collizioni con pareti
                    fan.assegnaDirezione();
                    
                    sleep(10);
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
