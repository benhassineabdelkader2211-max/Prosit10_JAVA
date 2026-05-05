import java.util.*;

public class Main {
    public static void main(String[] args) {

        AffectationHashMap affectation = new AffectationHashMap();

        Employe e1 = new Employe(1, "Ali");
        Employe e2 = new Employe(2, "Sara");
        Employe e3 = new Employe(3, "Mohamed");

        Departement d1 = new Departement(1, "Informatique");
        Departement d2 = new Departement(2, "RH");
        Departement d3 = new Departement(3, "Finance");

        affectation.ajouterEmployeDepartement(e1, d1);
        affectation.ajouterEmployeDepartement(e2, d2);
        affectation.ajouterEmployeDepartement(e3, d3);

        System.out.println("\n=== affichage des affectations ===");
        affectation.afficherEmployesEtDepartements();

        System.out.println("\n=== tentative doublon ===");
        affectation.ajouterEmployeDepartement(e1, d3);

        System.out.println("\n=== liste des employes ===");
        affectation.afficherEmployes();

        System.out.println("\n=== liste des departements ===");
        affectation.afficherDepartements();

        System.out.println("\n=== recherche employe e2 ===");
        System.out.println(affectation.rechercherEmploye(e2));

        System.out.println("\n=== recherche departement d3 ===");
        System.out.println(affectation.rechercherDepartement(d3));

        System.out.println("\n=== suppression employe e2 ===");
        affectation.supprimerEmploye(e2);
        affectation.afficherEmployesEtDepartements();

        System.out.println("\n=== suppression affectation e3 - Finance ===");
        affectation.supprimerEmployeEtDepartement(e3, d3);
        affectation.afficherEmployesEtDepartements();

        System.out.println("\n=== tri par id ===");
        TreeMap<Employe, Departement> trie = affectation.trierMap();
        for (Map.Entry<Employe, Departement> entry : trie.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}
