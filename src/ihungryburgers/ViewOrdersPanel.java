/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ihungryburgers;

/**
 *
 * @author TN_Master
 */
import javax.swing.*;
import java.awt.*;
import utils.KeyBindUtils;

class ViewOrdersPanel extends JPanel {

    public ViewOrdersPanel(MainFrame mainFrame) {
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

        JButton btnPendingOrder = new Button("Pending Orders", e -> {
            mainFrame.showCard("PENDING_ORDERS");
        });
        btnPendingOrder.setToolTipText("Shortcut: 1");
        KeyBindUtils.bindKey(this, "1", () -> btnPendingOrder.doClick());
        pnlBtn.add(btnPendingOrder);

        pnlBtn.add(Box.createVerticalStrut(25));

        JButton btnPreparingOrder = new Button("Preparing Orders", e -> {
            mainFrame.showCard("PREPARING_ORDERS");
        });
        btnPreparingOrder.setToolTipText("Shortcut: 2");
        KeyBindUtils.bindKey(this, "2", () -> btnPreparingOrder.doClick());
        pnlBtn.add(btnPreparingOrder);

        pnlBtn.add(Box.createVerticalStrut(25));

        JButton btnDeliveredOrder = new Button("Delivered Orders", e -> {
            mainFrame.showCard("DELIVERED_ORDERS");
        });
        btnDeliveredOrder.setToolTipText("Shortcut: 3");
        KeyBindUtils.bindKey(this, "3", () -> btnDeliveredOrder.doClick());
        pnlBtn.add(btnDeliveredOrder);

        pnlBtn.add(Box.createVerticalStrut(25));

        JButton btnCancelledOrder = new Button("Cancelled Orders", e -> {
            mainFrame.showCard("CANCELLED_ORDERS");
        });
        btnCancelledOrder.setToolTipText("Shortcut: 4");
        KeyBindUtils.bindKey(this, "4", () -> btnCancelledOrder.doClick());
        pnlBtn.add(btnCancelledOrder);

        pnlBtn.add(Box.createVerticalGlue());

        JPanel pnlBottom = new JPanel();
        pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.X_AXIS));
        pnlBottom.setBackground(rightPanel.getBackground());
        pnlBottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 40));
        pnlBottom.add(Box.createHorizontalGlue());

        JButton btnBack = new Button("Back", (e) -> {
            mainFrame.showCard("HOME");
        });
        btnBack.setPreferredSize(new Dimension(100, 50));
        btnBack.setMaximumSize(new Dimension(100, 50));
        btnBack.setToolTipText("Shortcut: ESC");
        KeyBindUtils.bindKey(this, "ESCAPE", () -> btnBack.doClick());

        pnlBottom.add(btnBack);
        rightPanel.add(pnlBottom, BorderLayout.SOUTH);
        rightPanel.add(pnlBtn, BorderLayout.CENTER);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        split.setDividerLocation(450);
        split.setEnabled(false); // disable dragging
        split.setDividerSize(0);
        split.setBorder(null);

        add(split, BorderLayout.CENTER);

//        System.out.println(this.getPreferredSize());
    }
}
