package exercice5;

import java.io.*;
import java.util.Scanner;

public class exercice5v2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String readFile = readEntry("path of reading file");
        String writeFile = readEntry("path of writing file");

        File readingFile = new File(readFile); //Instantiation des 2 fichiers nécessaires
        File writingFile = new File(writeFile);

        try(FileInputStream inFile = new FileInputStream(readingFile)) { //Mise en place du flux de lecture

            try(FileOutputStream outFile = new FileOutputStream(writingFile)){ //Mise en place du flux d'écriture

                int entry;
                while ((entry = inFile.read()) != -1){ //Tant que le fichier contient des lignes, on écrit dans l'autre fichier ce contenu
                    outFile.write(entry);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Raised exception : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Raised exception : " + e.getMessage());
        }
    }

    public static String readEntry(String file) { //Méthode pour demander l'entrée utilisateur
        System.out.println("Enter the " + file);
        return sc.next();
    }
}
