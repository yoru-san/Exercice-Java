package exercice4;

import java.io.*;
import java.util.Scanner;

public class ScannerFile {
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {

        String entry;
        String path = readEntry("path");
        File entryFile = new File(path);
        PrintWriter wt;
        try {
            wt = new PrintWriter(entryFile, "utf-8");

            do
            {
                entry = readEntry("text"); //On stocke l'entrée de l'utilisateur
                if (!entry.equals("quit")){
                    wt.write(entry + "\r\n"); //On écrit l'entrée en lui ajoutant le saut de ligne lorsque l'entrée est différente à "quit"
                }
            }
            while(!entry.equals("quit")); //Tant que l'entrée de l'utilisasteur est différente de "quit", on continue de demander d'écrire

            wt.close();
            BufferedReader rd = new BufferedReader(new FileReader(entryFile));
            String line;
            while((line = rd.readLine()) != null)
            {
                System.out.println(line); //On affiche tout le fichier
            }
            rd.close();

        } catch (IOException e) {
            System.out.println("Raised exception : " + e.getMessage());
        }
    }

    public static String readEntry(String entry) { //Méthode pour demander l'entrée utilisateur
        System.out.println("Enter the " + entry);
        return sc.next();
    }

}
