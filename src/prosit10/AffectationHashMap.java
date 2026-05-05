import java.util.*;

public class AffectationHashMap {

    private HashMap<Employe, Departement> map = new HashMap<>();

    public void ajouterEmployeDepartement(Employe e, Departement d) {
        if (map.containsKey(e)) {
            System.out.println("Employe " + e.getNom() + " est deja affecte !");
        } else {
            map.put(e, d);
        }
    }

    public void afficherEmployesEtDepartements() {
        for (Map.Entry<Employe, Departement> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    public void supprimerEmploye(Employe e) {
        if (map.containsKey(e)) {
            map.remove(e);
            System.out.println("Employe " + e.getNom() + " supprime.");
        } else {
            System.out.println("Employe non trouve.");
        }
    }

    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (map.containsKey(e) && map.get(e).equals(d)) {
            map.remove(e);
            System.out.println("Affectation supprimee.");
        } else {
            System.out.println("Affectation non trouvee.");
        }
    }

    public void afficherEmployes() {
        for (Employe e : map.keySet()) {
            System.out.println(e);
        }
    }

    public void afficherDepartements() {
        for (Departement d : map.values()) {
            System.out.println(d);
        }
    }

    public boolean rechercherEmploye(Employe e) {
        return map.containsKey(e);
    }

    public boolean rechercherDepartement(Departement d) {
        return map.containsValue(d);
    }

    public TreeMap<Employe, Departement> trierMap() {
        TreeMap<Employe, Departement> treeMap = new TreeMap<>((e1, e2) -> e1.getId() - e2.getId());
        treeMap.putAll(map);
        return treeMap;
    }
}
