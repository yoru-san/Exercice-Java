package exercice5;

import java.io.*;
import java.util.Scanner;

public class exercice5v2 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String readFile = readEntry("path of reading file");
        String writeFile = readEntry("path of writing file");

        File readingFile = new File(readFile);
        File writingFile = new File(writeFile);

        try(FileInputStream inFile = new FileInputStream(readingFile)) {

            try(FileOutputStream outFile = new FileOutputStream(writingFile)){

                int entry;
                while ((entry = inFile.read()) != -1){
                    outFile.write(entry);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Raised exception : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Raised exception : " + e.getMessage());
        }
    }

    public static String readEntry(String file) {
        System.out.println("Enter the " + file);
        return sc.next();
    }
}
