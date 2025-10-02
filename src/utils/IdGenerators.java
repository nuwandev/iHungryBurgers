package utils;

import models.OrderCollection;

public class IdGenerators {

    private static int customerCount = 1;

    public static String peekNextCustomerId() {
        String num = "" + customerCount;
        return "C" + pad(num);
    }

    public static String genCustomerId() {
        String id = peekNextCustomerId();
        customerCount++;
        return id;
    }

    public static String genOrderId(OrderCollection collection) {
        return "O" + pad(String.valueOf(collection.getAll().length + 1));
    }

    private static String pad(String num) {
        while (num.length() < 3) {
            num = "0" + num;
        }
        return num;
    }
}
