package exercice7.service;

import exercice7.domain.*;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    Class[] classes = new Class[] {
            ManutARisque.class,
            Manutentionnaire.class,
            Representant.class,
            TechnARisque.class,
            Technicien.class,
            Vendeur.class
    };

    public Employee MenuCreation() {
        System.out.println("Vous avez choisi de creer un nouvel employé");

        for (Class classe: classes) {
            System.out.println(Arrays.asList(classes).indexOf(classe) + " pour créer un " + classe.getSimpleName());
        }

        int entry = sc.nextInt();
        ArrayList listParams = new ArrayList();
        for (Parameter parameter: classes[entry].getConstructors()[0].getParameters()) {
            System.out.println(parameter.getName() + "(" + parameter.getType().getSimpleName() + ")");

            switch (parameter.getType().getSimpleName()) {
                case "String":
                    listParams.add(sc.next());
                    break;
                case "int":
                    listParams.add(sc.nextInt());
                    break;
                case "double":
                    listParams.add(sc.nextDouble());
                    break;
                default:
                    listParams.add(sc.next());
                    break;
            }

            System.out.println(listParams);
        }

        Employee nouvelEmploye = null;
        try {
            nouvelEmploye = (Employee) classes[entry].getConstructors()[0].newInstance(listParams.toArray());
        } catch (Exception e) {
            System.out.println("Exception levée :" + e.getMessage());
        }

        return nouvelEmploye;
    }

    public void ChoixAction(Personnel p) {
        boolean quit = true;
        while (quit) {
            System.out.println("Bienvenue! \nVeuillez choisir votre action : \nTapez 's' pour créer un nouvel employé \nTapez 'c' pour calculer les salaires \n");
            String choix = sc.next().toLowerCase();

            switch (choix) {
                case "s":
                    Employee nouvelEmploye = MenuCreation();
                    p.ajouterEmploye(nouvelEmploye);
                break;
                case "c":
                    p.afficherSalaires();
                    System.out.println(String.format("Le salaire moyen dans l'entreprise est de %.2f francs.", p.salaireMoyen()));
            }
        }
    }
}

