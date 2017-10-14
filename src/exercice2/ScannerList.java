package exercice2;

import java.io.File;
import java.util.Scanner;

public class ScannerList {
    static Scanner sc = new Scanner(System.in);

    public static void main (String[] args) {
        System.out.println("Your path: ");
        String path = sc.next();

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }
}
