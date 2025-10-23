package utils;

import model.Order;
import model.OrderList;

public class IdGenerators {

    private int nextCustomerNumber;
    private OrderList orderList;

    public IdGenerators(OrderList orderList) {
        this.orderList = orderList;
        this.updateNextCustomerNumber();
    }

    private void updateNextCustomerNumber() {
        if (orderList.isEmpty()) {
            this.nextCustomerNumber = 1;
            return;
        }

        Order[] ordersArr = orderList.toArray();
        int maxCustomerNum = 0;

        for (int i = 0; i < ordersArr.length; i++) {
            int num = Integer.parseInt(ordersArr[i].getCustomerID().substring(1));
            if (maxCustomerNum < num) {
                maxCustomerNum = num;
            }
        }
        this.nextCustomerNumber = maxCustomerNum + 1;
    }

    public String peekNextCustomerId() {
        String num = String.valueOf(nextCustomerNumber);
        return "C" + pad(num);
    }

    public String genCustomerId() {
        String id = peekNextCustomerId();
        nextCustomerNumber++;
        return id;
    }

    public String genOrderId() {
        return "O" + pad(String.valueOf(orderList.toArray().length + 1));
    }

    private String pad(String num) {
        while (num.length() < 3) {
            num = "0" + num;
        }
        return num;
    }
}
