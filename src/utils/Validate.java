/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author TN_Master
 */
public class Validate {

    public static boolean isValidOrderId(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            return false;
        }

        return orderId.charAt(0) == 'O';
    }
    
    public static boolean isValidCustomerId(String customerId) {
        return customerId != null && customerId.startsWith("C");
    }
}
