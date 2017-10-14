package exercice1;

import java.io.File;
import java.util.Scanner;

    public class ScannerPath {
        static Scanner sc = new Scanner(System.in);

        public static void main (String[] args) {
            System.out.println("Votre chemin: ");
            String path = sc.next();

            File testPath = new File(path);

            if (testPath.isFile()) {
                System.out.println("C'est un fichier");
            } else if (testPath.isDirectory()){
                System.out.println("C'est un dossier");
            } else {
                System.out.println("Le chemin ne mène ni à un dossier ni un fichier");
            }
        }
    }


