package sec01.exam02;

import java.io.Serializable;

public class Order implements Serializable {

    private String orderId;
    private String product;
    private int quantity;

    public Order(String orderId, String product, int quantity) {
        this.orderId = orderId;
        this.product = product;
        this.quantity = quantity;
    }

    public void print() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Product : " + product);
        System.out.println("Quantity: " + quantity);
    }

	public String getOrderId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getQuantity() {
		// TODO Auto-generated method stub
		return null;
	}
}
