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

    private ArrayList<BufferedImage> texFanBlu;

    private ArrayList<BufferedImage> texFanMarrone;

    private ArrayList<BufferedImage> texFanRosa;

    private ArrayList<BufferedImage> texFanRosso;

    private ArrayList<BufferedImage> texPacMan;

    private ArrayList<BufferedImage> texFanVerde;

    private ArrayList<BufferedImage> texFanViola;

    private BufferedImage textPallinoGiallo;
    
    private BufferedImage scrittaVittoria;
    
    private BufferedImage scrittaPerso;

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

    public void loadPallinoGiallo() {
        BufferedImage tmImage;
        try {
            tmImage = ImageIO.read(new File("./src/textures/PallinoGiallo/PallinoGiallo.png"));

            //Carico l'immagine completa
            textPallinoGiallo = tmImage.getSubimage(0, 0, 60, 60);

        } catch (IOException ex) {
            Logger.getLogger(TextureManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getTexPacMan(int posizione) {
        return texPacMan.get(posizione);
    }

    public Image getTexPalliniGialli() {
        return textPallinoGiallo;
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

    public void loadScrittaVittoria() {
        try {
            //Carico l'immagine completa
            scrittaVittoria = ImageIO.read(new File("./src/textures/ScrittaVittoria/ScrittaVittoria.png"));

        } catch (IOException ex) {
            Logger.getLogger(TextureManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getScrittaVittoria() {
        return scrittaVittoria;
    }

    public void loadScrittaPerso() {
        try {
            //Carico l'immagine completa
            scrittaPerso = ImageIO.read(new File("./src/textures/ScrittaPerso/ScrittaPerso.png"));

        } catch (IOException ex) {
            Logger.getLogger(TextureManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getScrittaPerso() {
        return scrittaPerso;
    }

}
