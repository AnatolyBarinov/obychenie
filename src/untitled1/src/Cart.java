import java.util.ArrayList;
import java.util.List;
//SOLID Принцип подстановки Барбары Лисков
// класс "Cart" может использовать любой объект типа "Product"

public class Cart {
    private List<Product> items;
    private double totalPrice;

    public Cart() {
        items = new ArrayList<>();
        totalPrice = 0;
    }

    public void addItem(Product product) {
        items.add(product);
        totalPrice += product.getPrice();
    }

    public void removeItem(Product product) {
        items.remove(product);
        totalPrice -= product.getPrice();
    }

    public List<Product> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void clearCart() {
        items.clear();
        totalPrice = 0;
    }

    // Дополнительные методы для возврата, повторного заказа и других функциональностей

    public void returnItem(Product product) {
        if (items.contains(product)) {
            items.remove(product);
            totalPrice -= product.getPrice();
        }
    }

    public void repeatOrder(Store store, List<Product> products) {
        for (Product product : products) {
            if (store.getAllProducts().contains(product)) {
                items.add(product);
                totalPrice += product.getPrice();
            }
        }
    }

    // Дополнительные методы и функциональности
}