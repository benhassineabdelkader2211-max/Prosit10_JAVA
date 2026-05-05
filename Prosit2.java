public class Animal {

    String family;
    String name;
    int age;
    boolean isMammal;

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    @Override
    public String toString() {
        return "Animal { nom='" + name + "', famille='" + family +
               "', age=" + age + " ans, mammifere=" + isMammal + " }";
    }
}

class Zoo {

    Animal[] animals;
    String name;
    String city;
    int nbrCages;

    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[25];
    }

    public void displayZoo() {
        System.out.println("Informations du Zoo");
        System.out.println("Nom      : " + name);
        System.out.println("Ville    : " + city);
        System.out.println("Nb cages : " + nbrCages);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Zoo nom='").append(name).append(" ville=").append(city)
          .append(" cages=").append(nbrCages).append("\nAnimaux :\n");
        boolean aucun = true;
        for (Animal a : animals) {
            if (a != null) { sb.append("  - ").append(a).append("\n"); aucun = false; }
        }
        if (aucun) sb.append("  aucun animal\n");
        return sb.toString();
    }
}

class ZooManagement {

    public static void main(String[] args) {

        Animal lion     = new Animal("Felides",      "rex",     5,  true);
        Animal elephant = new Animal("Elephantides", "lisa",    12, true);
        Animal dauphin  = new Animal("Delphinides",  "Flipper", 8,  true);

        Zoo myZoo = new Zoo("Safari Park", "Tunis", 20);
        myZoo.animals[0] = lion;
        myZoo.animals[1] = elephant;
        myZoo.animals[4] = dauphin;

        myZoo.displayZoo();
        System.out.println();
        System.out.println(myZoo);
        System.out.println(lion);
    }
}
