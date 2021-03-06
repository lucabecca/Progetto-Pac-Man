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
    private ArrayList<Pallino> palliniGialli = new ArrayList<Pallino>();
    private int aumentoX = 55;
    private int aumentoY = aumentoX;
    private int posX;
    private int posY = 30;
    private int AltezzaEntitaMappa = 60;
    private int LarghezzaEntitĂ Mappa = AltezzaEntitaMappa;

    private int righeMappa = 0;
    private int colonneMappa = 0;

    Condivisa c;

    //costruttore, prende un file e lo legge
    public Mappa(Condivisa c, MainGame maingame) {
        filename = "./src/textures/mappe/";
        System.out.println(maingame.mappaScelta);
        switch (maingame.mappaScelta) {
            case "mappa1.png":
                filename += "mappa1.txt";
                break;
            case "mappa2.png":
                filename += "mappa2.txt";
                break;
            case "mappa3.png":
                filename += "mappa3.txt";
                break;
            default:
        System.out.println("Errore scelta mappa");
                break;
        }
        System.out.println(filename);
        this.c = c;
        readFile();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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
            posX = 5;
            for (int i = 0; i < map.length(); i++) {
                if (map.charAt(i) == '#') {
                    mura.add(new Rectangle(posX, posY, AltezzaEntitaMappa, LarghezzaEntitĂ Mappa));
                } else if (map.charAt(i) == '0') {
                    palliniGialli.add(new Pallino(c, posX, posY, AltezzaEntitaMappa, LarghezzaEntitĂ Mappa));
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
        return colonneMappa * LarghezzaEntitĂ Mappa;
    }

}
