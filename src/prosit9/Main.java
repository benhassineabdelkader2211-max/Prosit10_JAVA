public class Main {
    public static void main(String[] args) {

        DepartementHashSet dhs = new DepartementHashSet();

        Departement d1 = new Departement(3, "Informatique", 15);
        Departement d2 = new Departement(1, "RH", 8);
        Departement d3 = new Departement(2, "Finance", 10);
        Departement d4 = new Departement(4, "Marketing", 5);

        dhs.ajouterDepartement(d1);
        dhs.ajouterDepartement(d2);
        dhs.ajouterDepartement(d3);
        dhs.ajouterDepartement(d4);

        System.out.println("\n=== tentative doublon ===");
        dhs.ajouterDepartement(d1);

        System.out.println("\n=== affichage ===");
        dhs.afficherDepartements();

        System.out.println("\n=== recherche par nom RH ===");
        System.out.println(dhs.rechercherDepartement("RH"));

        System.out.println("\n=== recherche par objet d2 ===");
        System.out.println(dhs.rechercherDepartement(d2));

        System.out.println("\n=== suppression d3 ===");
        dhs.supprimerDepartement(d3);
        dhs.afficherDepartements();

        System.out.println("\n=== tri par id ===");
        dhs.trierDepartementsParId();

        System.out.println("\n=== tri par nom et nombreEmployes ===");
        dhs.trierDepartementsParNomEtNombreEmployes();
    }
}
