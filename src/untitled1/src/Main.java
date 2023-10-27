import java.util.Date;
import java.util.List;
import java.util.Scanner;
//Избегание магических чисел
//В классе "Main" в меню используются числовые значения для выбора опций.
// Эту проблему можно решить, создавать константы с понятными именами для каждой опции меню.
public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        createDummyProducts(store);  // Создание примеров товаров

        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в наш магазин!");

        Cart cart = new Cart();
        String deliveryAddress = "";

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Вывести доступные товары");
            System.out.println("2. Фильтровать товары");
            System.out.println("3. Добавить товар в корзину");
            System.out.println("4. Вывести содержимое корзины");
            System.out.println("5. Оформить заказ");
            System.out.println("0. Выход");

            System.out.print("Введите номер пункта меню: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Считываем перевод строки после числа
            // Solid принцип Открытости и закрытости (Open/Closed Principle)
            // Если потребуется добавить новую функциональность или опцию в меню, можно добавить новый пункт в switch-case,
            // не затрагивая существующий код.
            switch (choice) {
                case 1:
                    List<Product> products = store.getAllProducts();
                    displayProducts(products);
                    break;
                case 2:
                    System.out.print("Введите ключевое слово для фильтрации: ");
                    String keyword = scanner.nextLine();
                    products = store.filterProductsByKeyword(keyword);
                    displayProducts(products);
                    break;
                case 3:
                    System.out.print("Введите название товара: ");
                    String productName = scanner.nextLine();
                    Product product = findProductByName(store, productName);
                    if (product != null) {
                        cart.addItem(product);
                        System.out.println("Товар добавлен в корзину.");
                    } else {
                        System.out.println("Товар не найден.");
                    }
                    break;
                case 4:
                    List<Product> cartItems = cart.getItems();
                    displayProducts(cartItems);
                    System.out.println("Общая стоимость: $" + cart.getTotalPrice());
                    break;
                case 5:
                    if (cart.getItems().isEmpty()) {
                        System.out.println("Корзина пуста. Невозможно оформить заказ.");
                    } else {
                        System.out.print("Введите адрес доставки: ");
                        deliveryAddress = scanner.nextLine();
                        Date orderDate = new Date();
                        Order order = new Order(generateOrderId(), cart, deliveryAddress, orderDate);
                        processOrder(order, store);
                        cart.clearCart();
                        deliveryAddress = "";
                    }
                    break;
                case 0:
                    System.out.println("До свидания!");
                    return;  // Выход из программы
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    private static void createDummyProducts(Store store) {
        // Создание примеров товаров
        Product product1 = new Product("Телефон", "Samsung", 1000, 4);
        Product product2 = new Product("Ноутбук", "Dell", 1500, 5);
        Product product3 = new Product("Наушники", "Sony", 200, 3);

        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
    }
//DRY
// displayProducts() отображает доступные товары. Этот метод используется как в пункте меню 1,
// так и в пункте меню 2 для отображения отфильтрованных товаров. Таким образом, избегается повторение кода,
// и вывод товаров вынесен в отдельный метод.
    private static void displayProducts(List<Product> products) {
        System.out.println("Доступные товары:");
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
        System.out.println();
    }

    private static Product findProductByName(Store store, String name) {
        List<Product> products = store.getAllProducts();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;  // Товар не найден
    }

    private static int generateOrderId() {
        // Генерация уникального ID для заказа
        // В реальной системе, здесь можно использовать, например, UUID.randomUUID().toString()
        return (int) (Math.random() * 1000);
    }

    private static void processOrder(Order order, Store store) {
        store.removeItemsFromStock(order.getCart().getItems());
        System.out.println("Заказ #" + order.getOrderId() + " успешно оформлен и отправлен по адресу: " + order.getDeliveryAddress());
        System.out.println();
    }
}