import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(3, "Laptop", 1200.0));
        products.add(new Product(1, "Souris", 25.0));
        products.add(new Product(2, "Clavier", 75.0));
        products.add(new Product(4, "Ecran", 350.0));

        ProductManagement pm = new ProductManagement();

        System.out.println("tous les produits :");
        pm.displayProducts(products, p -> System.out.println(p));

        System.out.println("\nproduits avec prix > 100 :");
        pm.displayProductsByFilter(products, p -> p.getPrix() > 100, p -> System.out.println(p));

        System.out.println("\nnoms des produits :");
        String noms = pm.returnProductsNames(products, p -> p.getNom());
        System.out.println(noms);

        System.out.println("\ncreation d'un produit :");
        Product newP = pm.createProduct(() -> new Product(5, "Webcam", 60.0));
        System.out.println(newP);

        System.out.println("\nproduits tries par id :");
        List<Product> sorted = pm.sortProductsById(products, (p1, p2) -> p1.getId() - p2.getId());
        pm.displayProducts(sorted, p -> System.out.println(p));

        System.out.println("\nconversion en stream :");
        pm.convertToStream(products).forEach(p -> System.out.println(p));
    }
}
