/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author TN_Master
 */
public class Order {

    public static final double BURGERPRICE = 500;
    public static final int PENDING = 0;
    public static final int PREPARING = 1;
    public static final int DELIVERED = 2;
    public static final int CANCELLED = 3;

    private String orderID;
    private String customerID;
    private String customerName;
    private int quantity;
    private double totalPrice;
    private int orderStatus;

    public Order(String orderID, String customerID, String customerName, int quantity) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.quantity = quantity;
        this.totalPrice = this.quantity * BURGERPRICE;
        this.orderStatus = PENDING;
    }

    //getters
    public String getOrderID() {
        return this.orderID;
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public String getOrderStatus() {
        if (this.orderStatus == PENDING) {
            return "Pending...";
        } else if (this.orderStatus == PREPARING) {
            return "Preparing";
        } else if (this.orderStatus == DELIVERED) {
            return "Delivered";
        } else if (this.orderStatus == CANCELLED) {
            return "Cancelled";
        } else {
            return "undefined";
        }
    }

    // setters
    public void setOrderID(String id) {
        this.orderID = id;
    }

    public void setCustomerID(String id) {
        this.customerID = id;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void setQuantity(int qty) {
        this.quantity = qty;
        setTotalPrice(quantity * Order.BURGERPRICE);
    }

    public void setTotalPrice(double tot) {
        this.totalPrice = tot;
    }

    public void setOrderStatus(String status) {
        int statusId = switch (status) {
            case "Pending..." -> Order.PENDING;
            case "Preparing" -> Order.PREPARING;
            case "Delivered" -> Order.DELIVERED;
            case "Cancelled" -> Order.CANCELLED;
            default -> -1;
        };

        this.orderStatus = statusId;
    }
}
