import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> filterProductsByKeyword(String keyword) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public List<Product> filterProductsByPriceRange(double minPrice, double maxPrice) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public List<Product> filterProductsByManufacturer(String manufacturer) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getManufacturer().equalsIgnoreCase(manufacturer)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    // Дополнительные методы для рейтинга и рекомендаций

    public double calculateAverageRating() {
        if (products.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (Product product : products) {
            sum += product.getRating();
        }
        return (double) sum / products.size();
    }

    public List<Product> recommendProducts(int ratingThreshold) {
        List<Product> recommendedProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getRating() >= ratingThreshold) {
                recommendedProducts.add(product);
            }
        }
        return recommendedProducts;
    }


//SOLID Принцип подстановки Барбары Лисков
// removeItemsFromStock()  может принимать список объектов типа "Product".
// Это гарантирует, что дочерние классы "Product" могут быть использованы вместо базового класса без нарушения функциональности
    public void removeItemsFromStock(List<Product> items) {
        for (Product item : items) {
            // Удаление товара из запасов магазина
            if (products.contains(item)) {
                products.remove(item);
                System.out.println("Товар " + item.getName() + " удален из запасов магазина.");
            }
        }
    }

    // Дополнительные методы и функциональности
}