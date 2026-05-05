import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class ProductManagement {

    public void displayProducts(List<Product> products, Consumer<Product> con) {
        for (Product p : products) {
            con.accept(p);
        }
    }

    public void displayProductsByFilter(List<Product> products, Predicate<Product> pre, Consumer<Product> con) {
        for (Product p : products) {
            if (pre.test(p)) {
                con.accept(p);
            }
        }
    }

    public String returnProductsNames(List<Product> products, Function<Product, String> fun) {
        String result = "";
        for (Product p : products) {
            result += fun.apply(p) + " ";
        }
        return result.trim();
    }

    public Product createProduct(Supplier<Product> sup) {
        return sup.get();
    }

    public List<Product> sortProductsById(List<Product> products, Comparator<Product> com) {
        List<Product> liste = new ArrayList<>(products);
        Collections.sort(liste, com);
        return liste;
    }

    public Stream<Product> convertToStream(List<Product> products) {
        return products.stream();
    }
}
