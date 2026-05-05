import java.util.*;

class Departement {
    private int id;
    private String nomDepartement;
    private int nombreEmployes;

    public Departement() {}

    public Departement(int id, String nomDepartement, int nombreEmployes) {
        this.id = id;
        this.nomDepartement = nomDepartement;
        this.nombreEmployes = nombreEmployes;
    }

    public int getId() { return id; }
    public String getNomDepartement() { return nomDepartement; }
    public int getNombreEmployes() { return nombreEmployes; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departement)) return false;
        Departement d = (Departement) o;
        return id == d.id && nomDepartement.equals(d.nomDepartement);
    }

    @Override
    public int hashCode() { return 31 * id + nomDepartement.hashCode(); }

    @Override
    public String toString() {
        return "Departement [id=" + id + ", nom=" + nomDepartement + ", nombreEmployes=" + nombreEmployes + "]";
    }
}

class DepartementHashSet {

    private HashSet<Departement> hashSet = new HashSet<>();

    public void ajouterDepartement(Departement d) {
        if (hashSet.contains(d)) System.out.println("Departement deja existant !");
        else { hashSet.add(d); System.out.println("Departement ajoute : " + d); }
    }

    public boolean rechercherDepartement(String nomDepartement) {
        for (Departement d : hashSet) if (d.getNomDepartement().equals(nomDepartement)) return true;
        return false;
    }

    public boolean rechercherDepartement(Departement dep) { return hashSet.contains(dep); }

    public void supprimerDepartement(Departement dep) {
        if (hashSet.remove(dep)) System.out.println("supprime : " + dep);
        else System.out.println("non trouve !");
    }

    public void afficherDepartements() {
        for (Departement d : hashSet) System.out.println(d);
    }

    public void trierDepartementsParId() {
        List<Departement> liste = new ArrayList<>(hashSet);
        Collections.sort(liste, (d1, d2) -> d1.getId() - d2.getId());
        System.out.println("=== tries par id ===");
        for (Departement d : liste) System.out.println(d);
    }

    public void trierDepartementsParNomEtNombreEmployes() {
        List<Departement> liste = new ArrayList<>(hashSet);
        Collections.sort(liste, (d1, d2) -> {
            int cmp = d1.getNomDepartement().compareTo(d2.getNomDepartement());
            return cmp != 0 ? cmp : d1.getNombreEmployes() - d2.getNombreEmployes();
        });
        System.out.println("=== tries par nom et nombreEmployes ===");
        for (Departement d : liste) System.out.println(d);
    }
}

public class Prosit9 {
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

        System.out.println("\n=== doublon ===");
        dhs.ajouterDepartement(d1);

        System.out.println("\n=== affichage ===");
        dhs.afficherDepartements();

        System.out.println("\n=== recherche par nom RH ===");
        System.out.println(dhs.rechercherDepartement("RH"));

        System.out.println("\n=== suppression d3 ===");
        dhs.supprimerDepartement(d3);
        dhs.afficherDepartements();

        System.out.println();
        dhs.trierDepartementsParId();

        System.out.println();
        dhs.trierDepartementsParNomEtNombreEmployes();
    }
}
