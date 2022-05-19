/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Giordano
 */
class Mappa extends Rectangle {
    //un quadrato deve essere 50x50
    //la mappa deve partire in alto a sinistra

    String filename = "";
    private ArrayList<String> mappa = new ArrayList<String>();
    private ArrayList<Rectangle> mura = new ArrayList<Rectangle>();
    private ArrayList<Rectangle> palliniGialli = new ArrayList<Rectangle>();
    private int aumentoX = 55;
    private int aumentoY = aumentoX;
    private int posX;
    private int posY = 31;
    private int AltezzaEntitaMappa = 60;
    private int LarghezzaEntitàMappa = AltezzaEntitaMappa;

    private int righeMappa = 0;
    private int colonneMappa = 0;

    Condivisa c;

    //costruttore, prende un file e lo legge
    public Mappa(Condivisa c) {
        filename = "./src/textures/mappe/mappa1.txt";
        this.c = c;
        readFile();
    }

    private void readFile() {

        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);

            //mappa = new String[myReader. ]
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                mappa.add(data);
                System.out.println(data);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void trovaCancelletto() {
        for (String map : mappa) {
            righeMappa++;
            for (int i = 0; i < map.length(); i++) {
                colonneMappa++;
                if (map.charAt(i) == '#') //disegna
                {
                    System.out.println("disegno muro");
                } else if (map.charAt(i) == '0') {
                    System.out.println("disegno pallino giallo");
                }
            }
        }
        colonneMappa = colonneMappa / righeMappa;
    }

    public void crea() {
        for (String map : mappa) {
            posX = 8;
            for (int i = 0; i < map.length(); i++) {
                if (map.charAt(i) == '#') {
                    mura.add(new Rectangle(posX, posY, AltezzaEntitaMappa, LarghezzaEntitàMappa));
                } else if (map.charAt(i) == '0') {
                    palliniGialli.add(new Rectangle(posX, posY, AltezzaEntitaMappa, LarghezzaEntitàMappa));
                }

                posX += aumentoX;
            }
            posY += aumentoY;
        }
        c.setMuraMappa(mura);
        c.setPalliniGialli(palliniGialli);
    }

    public int getAltezza() {
        return righeMappa * AltezzaEntitaMappa;
    }

    public int getLarghezza() {
        return colonneMappa * LarghezzaEntitàMappa;
    }

}
