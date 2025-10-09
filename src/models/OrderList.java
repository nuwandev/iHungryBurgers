/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import static models.Order.CANCELLED;
import static models.Order.DELIVERED;
import static models.Order.PENDING;
import static models.Order.PREPARING;
import utils.StorageManager;

/**
 *
 * @author TN_Master
 */
public class OrderList {

    private Order[] orders;
    private int nextIndex;
    private double loadFactor;
    private int initSize;

    public OrderList() {
        this.initSize = 100;
        this.loadFactor = 0.5;
        this.orders = new Order[this.initSize];
        this.nextIndex = 0;
    }

    public OrderList(int initSize) {
        this.initSize = initSize;
        this.loadFactor = 0.5;
        this.orders = new Order[initSize];
        this.nextIndex = 0;
    }

    public OrderList(int initSize, double loadFactor) {
        this.initSize = initSize;
        this.loadFactor = loadFactor;
        this.orders = new Order[initSize];
        this.nextIndex = 0;
    }

    public void add(Order order, boolean shouldSave) {
        if (orders.length <= nextIndex) {
            extendList();
        }

        orders[nextIndex++] = order;

        if (shouldSave) {
            StorageManager.saveOrder(order);
        }
    }

//    public void add(int index, Order order) {
//        if (orders.length <= nextIndex) {
//            extendList();
//        }
//
//        if (index >= 0 && index <= this.size()) {
//            for (int i = nextIndex - 1; i >= index; i--) {
//                orders[i + 1] = orders[i];
//            }
//            orders[index] = order;
//            nextIndex++;
//        }
//    }
    private void extendList() {
        Order[] tmpArr = new Order[(int) (orders.length * (1 + this.loadFactor))];
        for (int i = 0; i < nextIndex; i++) {
            tmpArr[i] = orders[i];
        }
        orders = tmpArr;
    }

//    public void remove(int index) {
//        for (int i = index; i < nextIndex - 1; i++) {
//            orders[i] = orders[i + 1];
//        }
//        nextIndex--;
//    }
    public Order get(int index) {
        if (index >= 0 && index < nextIndex) {
            return orders[index];
        }
        return null;
    }

    public boolean isEmpty() {
        return nextIndex == 0;
    }

    public int size() {
        return nextIndex;
    }

    public boolean contains(Order order) {
        return indexOf(order) != -1;
    }

    public int indexOf(Order order) {
        for (int i = 0; i < nextIndex; i++) {
            if (orders[i].getOrderID().equals(order.getOrderID())) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        this.orders = new Order[initSize];
        this.nextIndex = 0;
    }

    public Order[] toArray() {
        Order[] arr = new Order[nextIndex];
        for (int i = 0; i < nextIndex; i++) {
            arr[i] = orders[i];
        }
        return arr;
    }

    public String getCustomerId(String name) {
        for (int i = 0; i < nextIndex; i++) {
            if (orders[i].getCustomerName().equals(name)) {
                return orders[i].getCustomerID();
            }
        }
        return null;
    }

    public OrderList getUniqueList() {
        OrderList uniqueList = new OrderList(nextIndex, 0.25);

        for (int i = 0; i < nextIndex; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (this.toArray()[i].getCustomerID().equals(this.toArray()[j].getCustomerID())) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                String orderId = this.toArray()[i].getOrderID();
                String customerId = this.toArray()[i].getCustomerID();
                String customerName = this.toArray()[i].getCustomerName();
                int qty = this.toArray()[i].getQuantity();

                uniqueList.add(new Order(orderId, customerId, customerName, qty), false);
            }
        }

        for (int i = 0; i < uniqueList.toArray().length; i++) {
            double sum = 0;
            for (int j = 0; j < nextIndex; j++) {
                if (this.toArray()[j].getCustomerID().equals(uniqueList.toArray()[i].getCustomerID())) {
                    sum += this.toArray()[j].getTotalPrice();
                }
            }
            uniqueList.toArray()[i].setTotalPrice(sum);
        }

        return uniqueList;
    }

    public Order findOrder(String orderId) {
        for (int i = 0; i < nextIndex; i++) {
            if (orders[i].getOrderID().equals(orderId)) {
                return orders[i];
            }
        }
        return null;
    }

    public OrderList getCustomerInfo(String customerId) {
        OrderList customerInfoList = new OrderList(nextIndex);

        for (int i = 0; i < nextIndex; i++) {
            if (this.toArray()[i].getCustomerID().equals(customerId)) {
                customerInfoList.add(this.toArray()[i], false);
            }
        }

        if (customerInfoList.toArray().length == 0) {
            return null;
        }

        return customerInfoList;
    }

    public OrderList getFilteredList(int status) {
        OrderList filteredList = new OrderList(nextIndex);

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

        for (int i = 0; i < nextIndex; i++) {
            Order o = this.toArray()[i];
            if (o.getOrderStatus().equals(orderStatus)) {
                String orderId = o.getOrderID();
                String customerId = o.getCustomerID();
                String name = o.getCustomerName();
                int qty = o.getQuantity();

                filteredList.add(new Order(orderId, customerId, name, qty), false);
            }
        }

        return filteredList;
    }

}
