import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class Product {
    private int id;
    private String nom;
    private double prix;

    public Product() {}

    public Product(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public double getPrix() { return prix; }

    @Override
    public String toString() {
        return "Product [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
    }
}

class ProductManagement {

    public void displayProducts(List<Product> products, Consumer<Product> con) {
        for (Product p : products) con.accept(p);
    }

    public void displayProductsByFilter(List<Product> products, Predicate<Product> pre, Consumer<Product> con) {
        for (Product p : products) if (pre.test(p)) con.accept(p);
    }

    public String returnProductsNames(List<Product> products, Function<Product, String> fun) {
        String result = "";
        for (Product p : products) result += fun.apply(p) + " ";
        return result.trim();
    }

    public Product createProduct(Supplier<Product> sup) { return sup.get(); }

    public List<Product> sortProductsById(List<Product> products, Comparator<Product> com) {
        List<Product> liste = new ArrayList<>(products);
        Collections.sort(liste, com);
        return liste;
    }

    public Stream<Product> convertToStream(List<Product> products) { return products.stream(); }
}

public class Prosit11 {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(3, "Laptop",  1200.0));
        products.add(new Product(1, "Souris",    25.0));
        products.add(new Product(2, "Clavier",   75.0));
        products.add(new Product(4, "Ecran",    350.0));

        ProductManagement pm = new ProductManagement();

        System.out.println("tous les produits :");
        pm.displayProducts(products, p -> System.out.println(p));

        System.out.println("\nproduits avec prix > 100 :");
        pm.displayProductsByFilter(products, p -> p.getPrix() > 100, p -> System.out.println(p));

        System.out.println("\nnoms :");
        System.out.println(pm.returnProductsNames(products, p -> p.getNom()));

        System.out.println("\ncreation :");
        Product newP = pm.createProduct(() -> new Product(5, "Webcam", 60.0));
        System.out.println(newP);

        System.out.println("\ntries par id :");
        List<Product> sorted = pm.sortProductsById(products, (p1, p2) -> p1.getId() - p2.getId());
        pm.displayProducts(sorted, p -> System.out.println(p));

        System.out.println("\nstream :");
        pm.convertToStream(products).forEach(p -> System.out.println(p));
    }
}
