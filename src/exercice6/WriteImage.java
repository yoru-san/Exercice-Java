package exercice6;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WriteImage {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String imageFormat = readEntry("image format");
        String path = readEntry("path");
        String link = "https://";
        link += readEntry("url without 'https://'");
        File imageFile = new File(path);
        BufferedImage image;
        try {

            URL url = new URL(link); //Création de l'URL
            image = ImageIO.read(url); //Lecture de l'URL

            ImageIO.write(image, imageFormat , imageFile); //Ecriture de l'image dans le bon fichier au bon format

        } catch (IOException e) {
            System.out.println("Raised exception : " + e.getMessage());
        }
    }

    public static String readEntry(String entry) { //Méthode pour demander l'entrée utilisateur
        System.out.println("Enter the " + entry);
        return sc.next();
    }
}
