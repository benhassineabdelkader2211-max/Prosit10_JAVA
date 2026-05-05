import java.util.*;

public class DepartementHashSet {

    private HashSet<Departement> hashSet = new HashSet<>();

    public void ajouterDepartement(Departement d) {
        if (hashSet.contains(d)) {
            System.out.println("Departement deja existant !");
        } else {
            hashSet.add(d);
            System.out.println("Departement ajoute : " + d);
        }
    }

    public boolean rechercherDepartement(String nomDepartement) {
        for (Departement d : hashSet) {
            if (d.getNomDepartement().equals(nomDepartement)) {
                return true;
            }
        }
        return false;
    }

    public boolean rechercherDepartement(Departement dep) {
        return hashSet.contains(dep);
    }

    public void supprimerDepartement(Departement dep) {
        if (hashSet.remove(dep)) {
            System.out.println("Departement supprime : " + dep);
        } else {
            System.out.println("Departement non trouve !");
        }
    }

    public void afficherDepartements() {
        for (Departement d : hashSet) {
            System.out.println(d);
        }
    }

    public void trierDepartementsParId() {
        List<Departement> liste = new ArrayList<>(hashSet);
        Collections.sort(liste, (d1, d2) -> d1.getId() - d2.getId());
        System.out.println("=== tries par id ===");
        for (Departement d : liste) {
            System.out.println(d);
        }
    }

    public void trierDepartementsParNomEtNombreEmployes() {
        List<Departement> liste = new ArrayList<>(hashSet);
        Collections.sort(liste, (d1, d2) -> {
            int cmp = d1.getNomDepartement().compareTo(d2.getNomDepartement());
            if (cmp != 0) return cmp;
            return d1.getNombreEmployes() - d2.getNombreEmployes();
        });
        System.out.println("=== tries par nom et nombreEmployes ===");
        for (Departement d : liste) {
            System.out.println(d);
        }
    }
}
