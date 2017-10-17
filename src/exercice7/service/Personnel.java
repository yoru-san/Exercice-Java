package exercice7.service;

import exercice7.domain.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Personnel implements java.io.Serializable {

    private List<Employee> employees;
    private static final String PRINT_PATTERN = "%s gagne %.2f euros";

    public Personnel() {
        this.employees = new ArrayList<>();
    }

    public void ajouterEmploye(Employee employee) {
        this.employees.add(employee);
    }

    public void afficherSalaires() {
        employees.forEach(employee -> System.out.println(String.format(PRINT_PATTERN, employee.getName(), employee.calculerSalaire())));
    }

    public double salaireMoyen() {
        double total = 0;
        for (Employee employee: employees) {
            total += employee.calculerSalaire();
        }
        return total / employees.size();
    }
//Essai de serialisation

    /*void serialiserPersonnel() {
        try {
            Personnel p = null;
            FileOutputStream fileOut = new FileOutputStream("personnel.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);
            out.close();
            fileOut.close();
            System.out.printf("Données sauvegardée dans personnel.txt");
        }catch(IOException e) {
            System.out.println("Exception levée " + e.getMessage());
        }
    }

    /*public void deserialiserPersonnel() {
        try {
            Personnel p;
            FileInputStream fileIn = new FileInputStream("personnel.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Personnel) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i) {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
    }*/
}

