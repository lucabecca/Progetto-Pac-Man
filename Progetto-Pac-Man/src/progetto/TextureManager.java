/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progetto;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class TextureManager {

    final int altezzaEntità = 50;
    final int larghezzaEntità = altezzaEntità;

    final int nAnimazioniPacMan = 5;

    final int nAnimazioniFantasma = 4;

    ArrayList<BufferedImage> texFanBlu;

    ArrayList<BufferedImage> texFanMarrone;

    ArrayList<BufferedImage> texFanRosa;

    ArrayList<BufferedImage> texFanRosso;

    ArrayList<BufferedImage> texPacMan;

    ArrayList<BufferedImage> texFanVerde;

    ArrayList<BufferedImage> texFanViola;

    public TextureManager() {
        texPacMan = new ArrayList<BufferedImage>();
        texFanBlu = new ArrayList<BufferedImage>();
        texFanMarrone = new ArrayList<BufferedImage>();
        texFanRosa = new ArrayList<BufferedImage>();
        texFanRosso = new ArrayList<BufferedImage>();
        texFanVerde = new ArrayList<BufferedImage>();
        texFanViola = new ArrayList<BufferedImage>();
    }

    public void loadPacMan() {
        BufferedImage tmpImg;
        try {
            //Carico l'immagine completa
            tmpImg = ImageIO.read(new File("./src/textures/PacMan/PacMan.png"));

            //La divido e la aggiungo ad un arrayLIst
            int x = 0, y = 0;
            for (int i = 0; i < nAnimazioniPacMan; i++) {
                texPacMan.add(tmpImg.getSubimage(x, y, larghezzaEntità, altezzaEntità));
                x += 50;
            }

        } catch (IOException ex) {
            Logger.getLogger(TextureManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadFantasma(int idFan) {
        BufferedImage tmpImg;

        int x = 0, y = 0;

        try {
            switch (idFan) {
                case 1:
                    //Carico l'immagine completa FantasmaBlu
                    tmpImg = ImageIO.read(new File("./src/textures/FantasmaBlu/FantasmaBlue.png"));

                    //La divido e la aggiungo ad un arrayLIst
                    x = 0;
                    y = 0;
                    for (int i = 0; i < nAnimazioniFantasma; i++) {
                        texFanBlu.add(tmpImg.getSubimage(x, y, larghezzaEntità, altezzaEntità));
                        x += 50;
                    }
                    break;
                case 2:
                    //Carico l'immagine completa FantasmaMarrone
                    tmpImg = ImageIO.read(new File("./src/textures/FantasmaMarrone/FantasmaMarrone.png"));

                    //La divido e la aggiungo ad un arrayLIst
                    x = 0;
                    y = 0;
                    for (int i = 0; i < nAnimazioniFantasma; i++) {
                        texFanMarrone.add(tmpImg.getSubimage(x, y, larghezzaEntità, altezzaEntità));
                        x += 50;
                    }
                    System.out.println("caricato e diviso");
                    break;
                case 3:
                    //Carico l'immagine completa FantasmaRosa
                    tmpImg = ImageIO.read(new File("./src/textures/FantasmaRosa/FantasmaRosa.png"));

                    //La divido e la aggiungo ad un arrayLIst
                    x = 0;
                    y = 0;
                    for (int i = 0; i < nAnimazioniFantasma; i++) {
                        texFanRosa.add(tmpImg.getSubimage(x, y, larghezzaEntità, altezzaEntità));
                        x += 50;
                    }
                    break;
                case 4:
                    //Carico l'immagine completa FantasmaRosso
                    tmpImg = ImageIO.read(new File("./src/textures/FantasmaRosso/FantasmaRosso.png"));

                    //La divido e la aggiungo ad un arrayLIst
                    x = 0;
                    y = 0;
                    for (int i = 0; i < nAnimazioniFantasma; i++) {
                        texFanRosso.add(tmpImg.getSubimage(x, y, larghezzaEntità, altezzaEntità));
                        x += 50;
                    }
                    break;
                case 5:
                    //Carico l'immagine completa FantasmaVerde
                    tmpImg = ImageIO.read(new File("./src/textures/FantasmaVerde/FantasmaVerde.png"));

                    //La divido e la aggiungo ad un arrayLIst
                    x = 0;
                    y = 0;
                    for (int i = 0; i < nAnimazioniFantasma; i++) {
                        texFanVerde.add(tmpImg.getSubimage(x, y, larghezzaEntità, altezzaEntità));
                        x += 50;
                    }
                    break;
                case 6:
                    //Carico l'immagine completa FantasmaViola
                    tmpImg = ImageIO.read(new File("./src/textures/FantasmaViola/FantasmaViola.png"));

                    //La divido e la aggiungo ad un arrayLIst
                    x = 0;
                    y = 0;
                    for (int i = 0; i < nAnimazioniFantasma; i++) {
                        texFanViola.add(tmpImg.getSubimage(x, y, larghezzaEntità, altezzaEntità));
                        x += 50;
                    }
                    break;
                default:
                    break;
            }
        } catch (IOException ex) {
            Logger.getLogger(TextureManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getTexPacMan(int posizione) {
        return texPacMan.get(posizione);
    }

    Image getTexFan(int idFan, int i) {
        try {
            switch (idFan) {
                case 1:
                    return texFanBlu.get(i);
                case 2:
                    return texFanMarrone.get(i);
                case 3:
                    return texFanRosa.get(i);
                case 4:
                    return texFanRosso.get(i);
                case 5:
                    return texFanVerde.get(i);
                case 6:
                    return texFanViola.get(i);
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public int getAltezzaEntità() {
        return altezzaEntità;
    }

    public int getLarghezzaEntità() {
        return larghezzaEntità;
    }
 
}
