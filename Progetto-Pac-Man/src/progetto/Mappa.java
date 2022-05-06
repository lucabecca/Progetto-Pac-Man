/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
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
    ArrayList<String> mappa = new ArrayList<String>();
    ArrayList<Rectangle> rettangoli= new ArrayList<Rectangle>();
    private int aumentoX = 55;
    private int aumentoY = 55;
    private int posX = aumentoX;
    private int posY = aumentoY;
    
    //costruttore, prende un file e lo legge
    public Mappa(){
        filename = "./src/textures/mappe/file1.txt";
        readFile();
    }
    private void readFile(){
        

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
    
    public void trovaCancelletto(){
        for(String map: mappa){
            for(int i = 0; i< map.length(); i++){
                if(map.charAt(i)=='#')
                    //disegna
                    System.out.println("disegno siepe");
            }
        }
    }
    
    public void crea() {
        
        for(String map: mappa){
            posX = aumentoX;
            for(int i = 0; i< map.length(); i++){
                if(map.charAt(i)=='#'){
                    //disegna
                    System.out.println("entro");
                    //g.setColor(Color.green);
                    //g.fillRect(posX, posY, 30, 30);
                    rettangoli.add(new Rectangle(posX, posY, 60, 60));
                }
                posX += aumentoX;
            }
            posY += aumentoY;
        }
    }

}