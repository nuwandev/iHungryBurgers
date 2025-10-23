/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;
import model.OrderList;

/**
 *
 * @author TN_Master
 */
public class StorageManager {

    private static String filePath = "src/storage/orders.txt";

    public StorageManager() {

    }

    public static OrderList loadOrderList() {
        OrderList orderList = new OrderList();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                String[] orderData = line.split(",");
//                System.out.println(Arrays.toString(orderData));
                String orderId = orderData[0];
                String customerId = orderData[1];
                String customerName = orderData[2];
                int quantity = Integer.parseInt(orderData[3]);
                String status = orderData[5];

                Order order = new Order(orderId, customerId, customerName, quantity);
                order.setOrderStatus(status);
                orderList.add(order);
            }
            System.out.println("OrderList loaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderList;
    }

    public static void refreshStorage(OrderList orderList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Order order : orderList.toArray()) {
                String orderId = order.getOrderID();
                String customerId = order.getCustomerID();
                String name = order.getCustomerName();
                String qty = String.valueOf(order.getQuantity());
                String total = String.valueOf(order.getTotalPrice());
                String status = order.getOrderStatus();
                bw.write(orderId + "," + customerId + "," + name + "," + qty + "," + total + "," + status);
                bw.newLine();
            }
            System.out.println("orders.txt file refreshed successfully.");
        } catch (IOException ex) {
            Logger.getLogger(StorageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveOrder(Order order) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            String orderId = order.getOrderID();
            String customerId = order.getCustomerID();
            String name = order.getCustomerName();
            String qty = String.valueOf(order.getQuantity());
            String total = String.valueOf(order.getTotalPrice());
            String status = order.getOrderStatus();
            bw.write(orderId + "," + customerId + "," + name + "," + qty + "," + total + "," + status);
            bw.newLine();
            System.out.println("orders.txt file updated successfully.");
        } catch (IOException ex) {
            Logger.getLogger(StorageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
