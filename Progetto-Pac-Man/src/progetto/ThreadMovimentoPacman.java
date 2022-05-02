/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadMovimentoPacman extends Thread {

    private PacMan pm;

    private int velocita = 1;

    private Fantasma fan;

    Condivisa c;

    public ThreadMovimentoPacman(PacMan pm, Fantasma fan, Condivisa c) {
        this.pm = pm;
        this.fan = fan;
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {

            while (c.isGameOver() == false) {
                try {

                    if (pm.getDirezione() == 'w') {
                        pm.subY(velocita);
                    } else if (pm.getDirezione() == 'a') {
                        pm.subX(velocita);
                    } else if (pm.getDirezione() == 's') {
                        pm.addY(velocita);
                    } else if (pm.getDirezione() == 'd') {
                        pm.addX(velocita);
                    }

                    // Controlla l'intersezione
                    if (pm.intersects(fan)) {
                        c.setGameOver(true);
                    }

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
