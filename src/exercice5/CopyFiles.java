package exercice5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CopyFiles {
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        String readFile = readEntry("reading file");
        String writeFile = readEntry("writing file");
        copy(readFile, writeFile);

    }
    public static String readEntry(String file) { //Méthode pour demander l'entrée utilisateur
        System.out.println("Enter the " + file);
        return sc.next();
    }

    public static void copy(String readFile, String writeFile) { //Méthode de copie
        try {
            Files.copy(Paths.get(readFile), new FileOutputStream(writeFile)); //On lui passe le fichier source et celui de destination
        } catch (IOException e) {
            System.out.println("Raised exception : " + e.getMessage());
        }
    }
}
