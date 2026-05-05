import java.util.Scanner;

public class Prosit1 {

    int nbrCages = 20;
    String zooName = "my zoo";

    void afficherInfo() {
        System.out.println(zooName + " comporte " + nbrCages + " cages");
    }

    public static void main(String[] args) {

        Prosit1 zoo = new Prosit1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenue \n");
        System.out.print("Valeurs par défaut → ");
        zoo.afficherInfo();

        String nomSaisi = "";
        while (nomSaisi.isEmpty()) {
            System.out.print("Entrez le nom : ");
            nomSaisi = scanner.nextLine().trim();
            if (nomSaisi.isEmpty()) System.out.println("Réessayez.");
        }
        zoo.zooName = nomSaisi;

        int cagesSaisies = 0;
        boolean valide = false;
        while (!valide) {
            System.out.print("Entrez le nombre de cages : ");
            String ligne = scanner.nextLine().trim();
            try {
                cagesSaisies = Integer.parseInt(ligne);
                if (cagesSaisies <= 0) System.out.println("Réessayez.");
                else valide = true;
            } catch (NumberFormatException e) {
                System.out.println("invalide");
            }
        }
        zoo.nbrCages = cagesSaisies;

        System.out.print("Nouvelles informations : ");
        zoo.afficherInfo();
        scanner.close();
    }
}
