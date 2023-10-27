import java.util.Date;

public class Order {
    private int orderId;
    private Cart cart;
    private String deliveryAddress;
    private boolean delivered;
    private Date orderDate;

    public Order(int orderId, Cart cart, String deliveryAddress, Date orderDate) {
        this.orderId = orderId;
        this.cart = cart;
        this.deliveryAddress = deliveryAddress;
        this.orderDate = orderDate;
        this.delivered = false;
    }

    public int getOrderId() {
        return orderId;
    }

    public Cart getCart() {
        return cart;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    // Дополнительные методы и функциональности
}