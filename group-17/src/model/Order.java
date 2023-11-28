package model;
import java.util.List;
public class Order {
    private int orderId;
    private User user;
    private List<Product> orderedProducts;
    private double totalAmount;
    private String shippingAddress;

}
