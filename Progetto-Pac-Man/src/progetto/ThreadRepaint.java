/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progetto;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRepaint extends Thread {

    private JFrame j;

    ThreadRepaint(JFrame j) {
        this.j = j;
    }

    @Override
    public void run() {
        while (true) {
            j.repaint();
            try {
                sleep(33);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadRepaint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
