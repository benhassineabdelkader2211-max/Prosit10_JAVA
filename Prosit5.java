class Animal {
    protected String family;
    protected String name;
    protected int age;
    protected boolean isMammal;

    public Animal() {}

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    @Override
    public String toString() {
        return "Animal { nom='" + name + "', famille='" + family +
               "', age=" + age + ", mammifere=" + isMammal + " }";
    }
}

class Aquatic extends Animal {
    protected String habitat;

    public Aquatic() {}

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public void swim() {
        System.out.println("This aquatic animal is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", habitat='" + habitat + "'";
    }
}

class Terrestrial extends Animal {
    protected int nbrLegs;

    public Terrestrial() {}

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }

    @Override
    public String toString() {
        return super.toString() + ", nbrLegs=" + nbrLegs;
    }
}

class Dolphin extends Aquatic {
    private float swimmingSpeed;

    public Dolphin() {}

    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimmingSpeed) {
        super(family, name, age, isMammal, habitat);
        this.swimmingSpeed = swimmingSpeed;
    }

    @Override
    public void swim() {
        System.out.println("This dolphin is swimming.");
    }

    @Override
    public String toString() {
        return super.toString() + ", swimmingSpeed=" + swimmingSpeed;
    }
}

class Penguin extends Aquatic {
    private float swimmingDepth;

    public Penguin() {}

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    @Override
    public String toString() {
        return super.toString() + ", swimmingDepth=" + swimmingDepth;
    }
}

public class Prosit5 {
    public static void main(String[] args) {

        Aquatic aquatic      = new Aquatic("Poissons",    "Nemo",    2, false, "ocean");
        Terrestrial terrestre = new Terrestrial("Felides", "Simba",   5, true,  4);
        Dolphin dauphin      = new Dolphin("Delphinides", "Flipper",  8, true,  "mer",    35.5f);
        Penguin pingouin     = new Penguin("Spheniscides","Pingu",    3, false, "bassin", 50.0f);

        System.out.println("=== toString ===");
        System.out.println(aquatic);
        System.out.println(terrestre);
        System.out.println(dauphin);
        System.out.println(pingouin);

        System.out.println("\n=== swim ===");
        aquatic.swim();
        dauphin.swim();
        pingouin.swim();
    }
}
