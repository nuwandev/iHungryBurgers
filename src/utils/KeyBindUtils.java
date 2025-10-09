/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author TN_Master
 */
package utils;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class KeyBindUtils {

    // Bind key globally to a panel/component
    public static void bindKey(JComponent component, String keyStroke, Runnable action) {
        component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                 .put(KeyStroke.getKeyStroke(keyStroke), keyStroke);
        component.getActionMap().put(keyStroke, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
            }
        });
    }

    // Bind Enter to trigger a JButton from a JTextField
    public static void bindEnter(JTextField textField, JButton button) {
        textField.addActionListener(e -> button.doClick());
    }
}
