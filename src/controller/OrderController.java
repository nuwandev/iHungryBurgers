/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Order;
import model.OrderList;
import storage.StorageManager;

/**
 *
 * @author TN_Master
 */
public class OrderController {

    private OrderList orderList;

    public OrderController() {
        this.orderList = StorageManager.loadOrderList();
    }

    public Order getOrderByOrderId(String orderId) {
        final Order[] result = {null};
        orderList.forEach(order -> {
            if (order.getOrderID().equals(orderId)) {
                result[0] = order;
                return false; // stop early
            }
            return true;
        });
        return result[0];
    }

    public String getCustomerIdByName(String name) {
        final String[] customerId = {null};
        orderList.forEach(order -> {
            if (order.getCustomerName().equals(name)) {
                customerId[0] = order.getCustomerID();
                return false;
            }
            return true;
        });

        return customerId[0];
    }

    public OrderList getUniqueCustomers() {
        final OrderList uniqueList = new OrderList();

        orderList.forEach(order -> {
            final boolean[] found = {false};

            uniqueList.forEach(uOrder -> {
                if (order.getCustomerID().equals(uOrder.getCustomerID())) {
                    found[0] = true;
                    return false;
                }
                return true;
            });

            if (!found[0]) {
                uniqueList.add(new Order(order));
            }

            return true;
        });

        uniqueList.forEach(uOrder -> {
            final double[] sum = {0};

            orderList.forEach(order -> {
                if (uOrder.getCustomerID().equals(order.getCustomerID())) {
                    sum[0] += order.getTotalPrice();
                }
                return true;
            });

            uOrder.setTotalPrice(sum[0]);
            return true;
        });

        return uniqueList;
    }

    public OrderList getOrdersByStatus(int status) {
        OrderList filteredOrders = new OrderList();

        orderList.forEach(order -> {
            if (order.getOrderStatusInConst() == status) {
                filteredOrders.add(order);
            }

            return true;
        });

        return filteredOrders;
    }

    public OrderList getOrdersByCustomerId(String customerId) {
        OrderList customerOrders = new OrderList();

        orderList.forEach(order -> {
            if (order.getCustomerID().equals(customerId)) {
                customerOrders.add(order);
            }
            return true;
        });

        return customerOrders.isEmpty() ? null : customerOrders;
    }

    public OrderList getOrderList() {
        return orderList;
    }
    
}
