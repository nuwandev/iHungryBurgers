package ihungryburgers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author TN_Master
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Button extends JButton {

    public Button(String text, ActionListener action) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 15));
        setPreferredSize(new Dimension(200, 50));
        setMaximumSize(new Dimension(200, 50));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        setBackground(new Color(0xb41f25));
        setForeground(new Color(0xf3f3f3));
        setFocusPainted(false);
        setBorder(BorderFactory.createLineBorder(new Color(0x27000c), 2, true));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setAlignmentX(Component.CENTER_ALIGNMENT);

        addActionListener(action);
    }
}
