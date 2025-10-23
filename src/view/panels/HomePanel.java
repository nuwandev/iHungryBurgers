/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.panels;

/**
 *
 * @author TN_Master
 */
import view.componenets.Button;
import javax.swing.*;
import java.awt.*;
import utils.KeyBindUtils;
import view.MainFrame;

public class HomePanel extends JPanel {

    public HomePanel(MainFrame mainFrame) {
        setLayout(new BorderLayout());

        // left
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBackground(new Color(0xf09a1f));

        JLabel lblBanner = new JLabel("iHungry Burgers");
        lblBanner.setHorizontalTextPosition(JLabel.CENTER);
        lblBanner.setVerticalTextPosition(JLabel.TOP);
        lblBanner.setFont(new Font("Cooper Black", Font.BOLD, 40));
        lblBanner.setForeground(new Color(0xb41f25));

        lblBanner.setIcon(new ImageIcon(getClass().getResource("/resources/burger-logo.jpg")));
        lblBanner.setHorizontalAlignment(JLabel.CENTER);
        lblBanner.setVerticalAlignment(JLabel.CENTER);

        JLabel lblCredit = new JLabel("@nuwandev");
        lblCredit.setFont(new Font("", Font.ITALIC, 20));
        lblCredit.setForeground(new Color(0x290b15));
        lblCredit.setHorizontalAlignment(JLabel.CENTER);
        lblCredit.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        leftPanel.add(lblBanner, BorderLayout.CENTER);
        leftPanel.add(lblCredit, BorderLayout.SOUTH);

        // right
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(0xf3f3f3));

        JPanel pnlBtn = new JPanel();
        pnlBtn.setLayout(new BoxLayout(pnlBtn, BoxLayout.Y_AXIS));
        pnlBtn.setBackground(rightPanel.getBackground());

        pnlBtn.add(Box.createVerticalGlue());

        JButton btnPlaceOrder = new Button("Place Order", e -> {
            mainFrame.showCard("PLACE_ORDER");
        });
        btnPlaceOrder.setToolTipText("Shortcut: 1");
        KeyBindUtils.bindKey(this, "1", () -> btnPlaceOrder.doClick());
        pnlBtn.add(btnPlaceOrder);

        pnlBtn.add(Box.createVerticalStrut(25));

        JButton btnBestCustomer = new Button("Search BestCustomer", e -> {
            mainFrame.showCard("BEST_CUSTOMER");
        });
        btnBestCustomer.setToolTipText("Shortcut: 2");
        KeyBindUtils.bindKey(this, "2", () -> btnBestCustomer.doClick());
        pnlBtn.add(btnBestCustomer);

        pnlBtn.add(Box.createVerticalStrut(25));

        JButton btnSerachOrder = new Button("Search Order", e -> {
            mainFrame.showCard("SEARCH_ORDER");
        });
        btnSerachOrder.setToolTipText("Shortcut: 3");
        KeyBindUtils.bindKey(this, "3", () -> btnSerachOrder.doClick());
        pnlBtn.add(btnSerachOrder);

        pnlBtn.add(Box.createVerticalStrut(25));

        JButton btnSearchCustomer = new Button("Search Customer", e -> {
            mainFrame.showCard("SEARCH_CUSTOMER");
        });
        btnSearchCustomer.setToolTipText("Shortcut: 4");
        KeyBindUtils.bindKey(this, "4", () -> btnSearchCustomer.doClick());
        pnlBtn.add(btnSearchCustomer);

        pnlBtn.add(Box.createVerticalStrut(25));

        JButton btnViewOrder = new Button("View Orders", e -> {
            mainFrame.showCard("VIEW_ORDERS");
        });
        btnViewOrder.setToolTipText("Shortcut: 5");
        KeyBindUtils.bindKey(this, "5", () -> btnViewOrder.doClick());
        pnlBtn.add(btnViewOrder);

        pnlBtn.add(Box.createVerticalStrut(25));

        JButton btnUpdateOrders = new Button("Update Order", e -> {
            mainFrame.showCard("UPDATE_ORDERS");
        });
        btnUpdateOrders.setToolTipText("Shortcut: 6");
        KeyBindUtils.bindKey(this, "6", () -> btnUpdateOrders.doClick());
        pnlBtn.add(btnUpdateOrders);

        pnlBtn.add(Box.createVerticalGlue());

        JPanel pnlBottom = new JPanel();
        pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.X_AXIS));
        pnlBottom.setBackground(rightPanel.getBackground());
        pnlBottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 40));
        pnlBottom.add(Box.createHorizontalGlue());

        JButton btnExit = new Button("Exit", (e) -> {
            System.exit(0);
        });
        btnExit.setPreferredSize(new Dimension(100, 50));
        btnExit.setMaximumSize(new Dimension(100, 50));
        btnExit.setToolTipText("Shortcut: ESC");
        KeyBindUtils.bindKey(this, "ESCAPE", () -> btnExit.doClick());

        pnlBottom.add(btnExit);
        rightPanel.add(pnlBottom, BorderLayout.SOUTH);
        rightPanel.add(pnlBtn, BorderLayout.CENTER);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        split.setDividerLocation(450);
        split.setEnabled(false); // disable dragging
        split.setDividerSize(0);
        split.setBorder(null);

        add(split, BorderLayout.CENTER);
    }
}
