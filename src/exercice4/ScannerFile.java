package exercice4;

import java.io.*;
import java.util.Scanner;

public class ScannerFile {
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {

        String entry;
        System.out.println("Enter the path");
        String path = sc.next();
        File entryFile = new File(path);
        PrintWriter wt;
        try {
            wt = new PrintWriter(entryFile, "utf-8");

            do
            {
                entry = readEntry("text");
                if (!entry.equals("quit")){
                    wt.write(entry + "\r\n");
                }
            }
            while(!entry.equals("quit"));

            wt.close();
            BufferedReader rd = new BufferedReader(new FileReader(entryFile));
            String line;
            while((line = rd.readLine()) != null)
            {
                System.out.println(line);
            }
            rd.close();

        } catch (IOException e) {
            System.out.println("Raised exception : " + e.getMessage());
        }
    }

    public static String readEntry(String entry) {
        System.out.println("Enter the " + entry);
        return sc.next();
    }

}
