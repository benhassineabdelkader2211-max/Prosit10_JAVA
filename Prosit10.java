import java.util.*;

class Employe {
    private int id;
    private String nom;

    public Employe() {}

    public Employe(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }

    @Override
    public String toString() { return "Employe [id=" + id + ", nom=" + nom + "]"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employe)) return false;
        return id == ((Employe) o).id;
    }

    @Override
    public int hashCode() { return Integer.hashCode(id); }
}

class Departement {
    private int id;
    private String nom;

    public Departement() {}

    public Departement(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }

    @Override
    public String toString() { return "Departement [id=" + id + ", nom=" + nom + "]"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departement)) return false;
        return id == ((Departement) o).id;
    }

    @Override
    public int hashCode() { return Integer.hashCode(id); }
}

class AffectationHashMap {

    private HashMap<Employe, Departement> map = new HashMap<>();

    public void ajouterEmployeDepartement(Employe e, Departement d) {
        if (map.containsKey(e)) System.out.println("Employe " + e.getNom() + " deja affecte !");
        else map.put(e, d);
    }

    public void afficherEmployesEtDepartements() {
        for (Map.Entry<Employe, Departement> entry : map.entrySet())
            System.out.println(entry.getKey() + " --> " + entry.getValue());
    }

    public void supprimerEmploye(Employe e) {
        if (map.containsKey(e)) { map.remove(e); System.out.println("supprime : " + e.getNom()); }
        else System.out.println("non trouve.");
    }

    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (map.containsKey(e) && map.get(e).equals(d)) { map.remove(e); System.out.println("affectation supprimee."); }
        else System.out.println("affectation non trouvee.");
    }

    public void afficherEmployes() {
        for (Employe e : map.keySet()) System.out.println(e);
    }

    public void afficherDepartements() {
        for (Departement d : map.values()) System.out.println(d);
    }

    public boolean rechercherEmploye(Employe e) { return map.containsKey(e); }

    public boolean rechercherDepartement(Departement d) { return map.containsValue(d); }

    public TreeMap<Employe, Departement> trierMap() {
        TreeMap<Employe, Departement> treeMap = new TreeMap<>((e1, e2) -> e1.getId() - e2.getId());
        treeMap.putAll(map);
        return treeMap;
    }
}

public class Prosit10 {
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

        System.out.println("\n=== affichage ===");
        affectation.afficherEmployesEtDepartements();

        System.out.println("\n=== doublon ===");
        affectation.ajouterEmployeDepartement(e1, d3);

        System.out.println("\n=== employes ===");
        affectation.afficherEmployes();

        System.out.println("\n=== suppression e2 ===");
        affectation.supprimerEmploye(e2);
        affectation.afficherEmployesEtDepartements();

        System.out.println("\n=== tri par id ===");
        TreeMap<Employe, Departement> trie = affectation.trierMap();
        for (Map.Entry<Employe, Departement> entry : trie.entrySet())
            System.out.println(entry.getKey() + " --> " + entry.getValue());
    }
}
