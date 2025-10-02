/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author TN_Master
 */
public class Utils {

    public static void clearAndFocus(JTextField field) {
        SwingUtilities.invokeLater(() -> {
            field.setText("");
            field.requestFocus();
        });
    }
}
