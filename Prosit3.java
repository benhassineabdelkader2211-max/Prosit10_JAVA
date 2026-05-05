class Animal {

    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        setAge(age);
        this.isMammal = isMammal;
    }

    public String getFamily() { return family; }
    public void setFamily(String family) { this.family = family; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) {
        if (age < 0) { System.out.println("age negatif !"); this.age = 0; }
        else this.age = age;
    }

    public boolean isMammal() { return isMammal; }
    public void setMammal(boolean isMammal) { this.isMammal = isMammal; }

    @Override
    public String toString() {
        return "Animal { nom='" + name + "', famille='" + family +
               "', age=" + age + ", mammifere=" + isMammal + " }";
    }
}

class Zoo {

    private Animal[] animals;
    private String name;
    private String city;
    private final int nbrCages = 25;
    private int animalCount;

    public Zoo(String name, String city) {
        setName(name);
        this.city = city;
        this.animals = new Animal[nbrCages];
        this.animalCount = 0;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) { System.out.println("nom vide !"); this.name = "Zoo Inconnu"; }
        else this.name = name;
    }

    public String getCity() { return city; }
    public int getNbrCages() { return nbrCages; }
    public int getAnimalCount() { return animalCount; }
    public boolean isFull() { return animalCount >= nbrCages; }

    public boolean addAnimal(Animal animal) {
        if (isFull()) { System.out.println("zoo plein !"); return false; }
        for (int i = 0; i < animalCount; i++) {
            if (animals[i].getName().equals(animal.getName())) { System.out.println("deja present !"); return false; }
        }
        animals[animalCount++] = animal;
        return true;
    }

    public void displayAnimals() {
        System.out.println("Animaux dans " + name + " (" + animalCount + ") :");
        for (int i = 0; i < animalCount; i++) System.out.println(" " + (i+1) + ". " + animals[i]);
    }

    public int searchAnimal(String name) {
        for (int i = 0; i < animalCount; i++) if (animals[i].getName().equals(name)) return i;
        return -1;
    }

    public boolean removeAnimal(String name) {
        int index = searchAnimal(name);
        if (index == -1) return false;
        for (int i = index; i < animalCount - 1; i++) animals[i] = animals[i+1];
        animals[--animalCount] = null;
        return true;
    }

    public Zoo biggestZoo(Zoo other) { return this.animalCount >= other.animalCount ? this : other; }

    public void displayZoo() {
        System.out.println("Nom: " + name + " | Ville: " + city + " | Cages: " + nbrCages + " | Animaux: " + animalCount);
    }
}

public class Prosit3 {

    public static void main(String[] args) {

        Zoo zooTunis = new Zoo("Zoo El Anis", "Tunis");
        Zoo zooSfax  = new Zoo("Zoo Sidi Mansour", "Sfax");

        Animal gazelle = new Animal("Bovides",     "Nour",    3, true);
        Animal fennec  = new Animal("Canides",      "Rami",    2, true);
        Animal aigle   = new Animal("Accipitrides", "Haythem", 5, false);

        System.out.println("-- Ajout --");
        System.out.println(zooTunis.addAnimal(gazelle));
        System.out.println(zooTunis.addAnimal(fennec));
        System.out.println(zooTunis.addAnimal(aigle));

        System.out.println("\n-- encapsulation --");
        Animal invalide = new Animal("Canides", "Aziz", -5, true);
        System.out.println("age : " + invalide.getAge());
        Zoo zooVide = new Zoo("", "Nabeul");
        System.out.println("nom : " + zooVide.getName());

        System.out.println("\n-- Affichage --");
        zooTunis.displayAnimals();

        System.out.println("\n-- Recherche --");
        System.out.println("Rami    : " + zooTunis.searchAnimal("Rami"));
        System.out.println("Inconnu : " + zooTunis.searchAnimal("Inconnu"));

        System.out.println("\n-- Suppression --");
        System.out.println(zooTunis.removeAnimal("Haythem"));
        zooTunis.displayAnimals();

        zooSfax.addAnimal(new Animal("Felides", "Malek",   4, true));
        zooSfax.addAnimal(new Animal("Canides", "Skander", 6, true));
        zooSfax.addAnimal(new Animal("Ursides", "Fares",   9, true));

        Zoo plusGrand = zooTunis.biggestZoo(zooSfax);
        System.out.println("Plus grand : " + plusGrand.getName() + " (" + plusGrand.getAnimalCount() + ")");

        zooTunis.displayZoo();
        zooSfax.displayZoo();
    }
}
