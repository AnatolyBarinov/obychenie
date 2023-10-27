import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Product> purchasedProducts;

    public User(String username) {
        this.username = username;
        this.purchasedProducts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<Product> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void addPurchasedProduct(Product product) {
        purchasedProducts.add(product);
    }

    // Другие методы для работы с пользователем
}