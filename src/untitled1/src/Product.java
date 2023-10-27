
//Избегание магических чисел
//
//В классе "Product" нет использования магических чисел.
// Класс содержит поля с понятными именами, такими как "price", "rating" и другие, которые не зависят
// от конкретного числового значения.
public class Product {
    private String name;
    private String manufacturer;
    private double price;
    private int rating;

    public Product(String name, String manufacturer, double price, int rating) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}