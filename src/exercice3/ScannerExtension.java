package exercice3;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class ScannerExtension {
    static Scanner sc = new Scanner(System.in);

    public static void main (String[] args) {
        String extension = readEntry("extension");
        String path = readEntry("path");

        File dir = new File(path);
        File [] files = dir.listFiles(new FilenameFilter() {
            //Fonction appelé à chaque fichier et si elle renvoit true, elle inclue le fichier dans la liste files, sinon elle le passe
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(extension);
            }
        });

        for (File file : files) {
            System.out.println(file); //On affiche tout  les fichiers ayant l'extension requise
        }
    }

    public static String readEntry(String entry) { //Méthode pour demander l'entrée utilisateur
        System.out.println("Enter the " + entry);
        return sc.next();
    }
}
