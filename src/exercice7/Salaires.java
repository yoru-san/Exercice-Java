package exercice7;

import exercice7.domain.*;
import exercice7.service.Menu;
import exercice7.service.Personnel;

public class Salaires {
    public static void main(String[] args) {

        Personnel p = new Personnel();
        Menu menu = new Menu();

        menu.ChoixAction();

        Employee nouvelEmploye = menu.MenuCreation();
        System.out.println("Ce connard gagne" + nouvelEmploye.calculerSalaire());

        p.ajouterEmploye(new Vendeur("Pierre", "Business", 45, "1995", 30000));
        p.ajouterEmploye(new Representant("Léon", "Vendtout", 25, "2001", 20000));
        p.ajouterEmploye(new Technicien("Yves", "Bosseur", 28, "1998", 1000));
        p.ajouterEmploye(new Manutentionnaire("Jeanne", "Stocketout", 32, "1998", 45));
        p.ajouterEmploye(new TechnARisque("Jean", "Flippe", 28, "2000", 1000));
        p.ajouterEmploye(new ManutARisque("Al", "Abordage", 30, "2001", 45));

        p.afficherSalaires();
        System.out.println(String.format(
                "Le salaire moyen dans l'entreprise est de %.2f francs.",
                p.salaireMoyen()
        ));
    }
}
