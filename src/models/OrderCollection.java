/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import static models.Order.CANCELLED;
import static models.Order.DELIVERED;
import static models.Order.PENDING;
import static models.Order.PREPARING;

/**
 *
 * @author TN_Master
 */
public class OrderCollection {

    private Order[] collection = new Order[0];

    public OrderCollection() {
    }

    public boolean add(Order order) {
        extendCollection(1);
        collection[collection.length - 1] = order;
        return true;
    }

    private void extendCollection(int count) {
        Order[] tmpCollection = new Order[collection.length + count];
        for (int i = 0; i < collection.length; i++) {
            tmpCollection[i] = collection[i];
        }
        collection = tmpCollection;
    }

    public Order[] getAll() {
        return collection;
    }

    public String getCustomerId(String name) {
        for (int i = 0; i < collection.length; i++) {
            if (collection[i].getCustomerName().equals(name)) {
                return collection[i].getCustomerID();
            }
        }
        return null;
    }

    public OrderCollection getUniqueList() {
        OrderCollection uniqueList = new OrderCollection();

        for (int i = 0; i < this.getAll().length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (this.getAll()[i].getCustomerID().equals(this.getAll()[j].getCustomerID())) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                String orderId = this.getAll()[i].getOrderID();
                String customerId = this.getAll()[i].getCustomerID();
                String customerName = this.getAll()[i].getCustomerName();
                int qty = this.getAll()[i].getQuantity();

                uniqueList.add(new Order(orderId, customerId, customerName, qty));
            }
        }

        for (int i = 0; i < uniqueList.getAll().length; i++) {
            double sum = 0;
            for (int j = 0; j < this.getAll().length; j++) {
                if (this.getAll()[j].getCustomerID().equals(uniqueList.getAll()[i].getCustomerID())) {
                    sum += this.getAll()[j].getTotalPrice();
                }
            }
            uniqueList.getAll()[i].setTotalPrice(sum);
        }

        return uniqueList;
    }

    public Order findOrder(String orderId) {
        for (Order o : this.collection) {
            if (o.getOrderID().equals(orderId)) {
                return o;
            }
        }
        return null;
    }

    public OrderCollection getCustomerInfo(String customerId) {
        OrderCollection customerInfo = new OrderCollection();

        for (int i = 0; i < this.getAll().length; i++) {
            if (this.getAll()[i].getCustomerID().equals(customerId)) {
                customerInfo.add(this.getAll()[i]);
            }
        }

        if (customerInfo.getAll().length == 0) {
            return null;
        }

        return customerInfo;
    }

    public OrderCollection getFilteredCollection(int status) {
        OrderCollection filteredCollection = new OrderCollection();
        
        String orderStatus;
        if (status == PENDING) {
            orderStatus = "Pending...";
        } else if (status == PREPARING) {
            orderStatus = "Preparing";
        } else if (status == DELIVERED) {
            orderStatus = "Delivered";
        } else if (status == CANCELLED) {
            orderStatus = "Cancelled";
        } else {
            orderStatus = "undefined";
        }

        for (int i = 0; i < this.getAll().length; i++) {
            Order o = this.getAll()[i];
            if (o.getOrderStatus().equals(orderStatus)) {
                String orderId = o.getOrderID();
                String customerId = o.getCustomerID();
                String name = o.getCustomerName();
                int qty = o.getQuantity();
                
                filteredCollection.add(new Order(orderId, customerId, name, qty));
            }
        }
        
        return filteredCollection;
    }
}
