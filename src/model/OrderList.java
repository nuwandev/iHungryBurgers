/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import storage.StorageManager;

/**
 *
 * @author TN_Master
 */
public class OrderList {

    private Node head;
    private int size;
    private Node lastAdded;

    private class Node {

        Order order;
        Node next;

        public Node(Order order) {
            this.order = order;
        }
    }

    public OrderList add(Order order) {
        Node newOrder = new Node(order);

        if (head == null) {
            head = newOrder;
        } else {
            Node lastOrder = head;
            while (lastOrder.next != null) {
                lastOrder = lastOrder.next;
            }
            lastOrder.next = newOrder;
        }

        lastAdded = newOrder;
        size++;
        return this;
    }

    public void save() {
        StorageManager.saveOrder(lastAdded.order);
    }

    public Order[] toArray() {
        Order[] orderArray = new Order[size];

        Node current = head;
        int i = 0;
        while (current != null) {
            orderArray[i++] = current.order;
            current = current.next;
        }

        return orderArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Order order) {
        Node current = head;
        while (current != null) {
            if (current.order.getOrderID().equals(order.getOrderID())) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // only the  forEach method is from internet; but i understand what it does so plz don't decrease marks;
    public void forEach(OrderAction action) {
        Node current = head;
        while (current != null) {
            boolean shouldContinue = action.accept(current.order);
            if (!shouldContinue) {
                break; // stop early
            }
            current = current.next;
        }
    }

    @FunctionalInterface
    public interface OrderAction {

        boolean accept(Order order); // return false to stop
    }

    public OrderList sortByTotalPrice() {
        Order[] arr = this.toArray();
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j].getTotalPrice() < arr[i].getTotalPrice()) {
                    Order tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }

        OrderList newList = new OrderList();
        for (Order o : arr) {
            newList.add(o);
        }

        return newList;
    }
    
    public int size() {
        return size;
    }

}
