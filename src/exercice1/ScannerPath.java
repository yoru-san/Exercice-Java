package exercice1;

import java.io.File;
import java.util.Scanner;

    public class ScannerPath {
        static Scanner sc = new Scanner(System.in);

        public static void main (String[] args) {
            System.out.println("Votre chemin: "); //Demande du chemin à l'utilisateur
            String path = sc.next();

            File testPath = new File(path);

            if (testPath.isFile()) { //On vérifie si le chemin mène à un fichier
                System.out.println("C'est un fichier");
            } else if (testPath.isDirectory()){
                System.out.println("C'est un dossier"); //On vérifie si le chemin mène à un fichier
            } else {
                System.out.println("Le chemin ne mène ni à un dossier ni un fichier"); //Dans le cas où le chemin ne mène à rien
            }
        }
    }


