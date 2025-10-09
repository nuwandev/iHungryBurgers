/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ihungryburgers;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import models.Order;
import models.OrderList;
import utils.KeyBindUtils;
import utils.StorageManager;
import utils.Utils;
import utils.Validate;

/**
 *
 * @author TN_Master
 */
public class UpdateOrderPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private OrderList orderList;
    private Order selectedOrder;

    /**
     * Creates new form PlaceOrderPanel
     */
    public UpdateOrderPanel(MainFrame mainFrame, OrderList orderList) {
        initComponents();
        this.mainFrame = mainFrame;
        this.orderList = orderList;

        btnBack.setBorder(BorderFactory.createLineBorder(new Color(0x27000c), 2, true));
        btnUpdate.setBorder(BorderFactory.createLineBorder(new Color(0x27000c), 2, true));

        KeyBindUtils.bindKey(this, "ESCAPE", () -> btnBack.doClick());
        KeyBindUtils.bindEnter(txtName, btnUpdate);
        KeyBindUtils.bindEnter(txtOrderId, btnUpdate);
        KeyBindUtils.bindEnter(txtQty, btnUpdate);

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                txtOrderId.setText("");
                reset();
            }
        });

        txtOrderId.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            private void showDetails() {
                String orderId = txtOrderId.getText();

                if (orderId.isEmpty()) {
                    return;
                }

                if (!Validate.isValidOrderId(orderId)) {
                    JOptionPane.showMessageDialog(UpdateOrderPanel.this, "Order id must start with 'O'", "Validation Error", JOptionPane.ERROR_MESSAGE);

                    Utils.clearAndFocus(txtOrderId);
                    return;
                }

                if (orderId.length() < 2) {
                    return;
                }

                System.out.println("Searching...");
                Order order = orderList.findOrder(orderId);

                if (order != null) {
                    UpdateOrderPanel.this.selectedOrder = order;

                    txtCustomerId.setText(order.getCustomerID());
                    txtName.setText(order.getCustomerName());
                    txtQty.setText(String.valueOf(order.getQuantity()));
                    comboBoxStatus.setSelectedItem(order.getOrderStatus());
                    txtTotal.setText(String.valueOf(order.getTotalPrice()));

                    txtName.setEnabled(false);
                    txtQty.setEnabled(false);

                    if (order.getOrderStatus().equals("Preparing")) {
                        lblErr.setText("This Order is already Preparing... You can not update this order...");
                    } else if (order.getOrderStatus().equals("Delivered")) {
                        lblErr.setText("This Order is already devlivered... You can not update this order...");
                    } else if (order.getOrderStatus().equals("Cancelled")) {
                        lblErr.setText("This Order is already cancelled... You can not update this order...");
                    } else {
                        lblErr.setText("");
                        txtName.setEnabled(true);
                        txtQty.setEnabled(true);
                    }

                } else {
                    reset();
                }
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                showDetails();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                showDetails();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                showDetails();
            }
        });

        txtQty.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            private void updateTotal() {
                String text = txtQty.getText().trim();
                if (text.isEmpty()) {
                    txtTotal.setText("0.00");
                    return;
                }

                try {
                    double total = Integer.parseInt(text) * Order.BURGERPRICE;
                    txtTotal.setText(String.format("%.2f", total));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                            UpdateOrderPanel.this,
                            "Quantity must be a number!",
                            "Invalid Input",
                            JOptionPane.ERROR_MESSAGE
                    );

                    Utils.clearAndFocus(txtQty);
                }
            }

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                updateTotal();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                updateTotal();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                updateTotal();
            }
        });

    }

    private void reset() {
        txtCustomerId.setText("");
        txtName.setText("");
        txtQty.setText("");
        comboBoxStatus.setSelectedIndex(0);
        txtTotal.setText("");
        lblErr.setText("");
        txtOrderId.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox<>();
        txtOrderId = new javax.swing.JTextField();
        txtCustomerId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        lblErr = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 243, 243));
        setForeground(new java.awt.Color(0, 0, 0));
        setPreferredSize(new java.awt.Dimension(900, 650));

        jPanel1.setBackground(new java.awt.Color(240, 154, 31));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Update Order");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnBack.setBackground(new java.awt.Color(180, 31, 37));
        btnBack.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setFocusPainted(false);
        btnBack.setMaximumSize(new java.awt.Dimension(100, 50));
        btnBack.setMinimumSize(new java.awt.Dimension(100, 50));
        btnBack.setPreferredSize(new java.awt.Dimension(100, 50));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Order Status");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Order Id");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Customer Id");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Order QTY");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Total");

        comboBoxStatus.setBackground(new java.awt.Color(243, 243, 243));
        comboBoxStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboBoxStatus.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending...", "Preparing", "Delivered", "Cancelled" }));
        comboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxStatusActionPerformed(evt);
            }
        });

        txtOrderId.setBackground(new java.awt.Color(243, 243, 243));
        txtOrderId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtOrderId.setForeground(new java.awt.Color(0, 0, 0));

        txtCustomerId.setBackground(new java.awt.Color(243, 243, 243));
        txtCustomerId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCustomerId.setForeground(new java.awt.Color(0, 0, 0));
        txtCustomerId.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtCustomerId.setEnabled(false);
        txtCustomerId.setFocusable(false);

        txtName.setBackground(new java.awt.Color(243, 243, 243));
        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(0, 0, 0));
        txtName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtName.setEnabled(false);

        txtQty.setBackground(new java.awt.Color(243, 243, 243));
        txtQty.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtQty.setForeground(new java.awt.Color(0, 0, 0));
        txtQty.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtQty.setEnabled(false);

        btnUpdate.setBackground(new java.awt.Color(180, 31, 37));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update Order");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setFocusPainted(false);
        btnUpdate.setMaximumSize(new java.awt.Dimension(100, 50));
        btnUpdate.setMinimumSize(new java.awt.Dimension(100, 50));
        btnUpdate.setPreferredSize(new java.awt.Dimension(100, 50));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtTotal.setBackground(new java.awt.Color(243, 243, 243));
        txtTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 0, 51));
        txtTotal.setDisabledTextColor(new java.awt.Color(255, 51, 0));
        txtTotal.setEnabled(false);
        txtTotal.setFocusable(false);

        lblErr.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblErr.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(575, Short.MAX_VALUE)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtOrderId)
                        .addComponent(txtCustomerId)
                        .addComponent(txtName)
                        .addComponent(txtQty)
                        .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                    .addComponent(lblErr, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lblErr, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOrderId)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerId))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQty))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotal))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        mainFrame.showCard("HOME");
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String customerName = txtName.getText().trim();
        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Customer Name!", "Error", JOptionPane.ERROR_MESSAGE);
            txtName.requestFocus();
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(txtQty.getText().trim());
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be positive number!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                txtQty.setText("");
                txtQty.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Quantity must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
            txtQty.requestFocus();
            return;
        }

        boolean needToUpdate = false;

        if (!selectedOrder.getCustomerName().equals(txtName.getText())) {
            needToUpdate = true;
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.toArray()[i].getCustomerID().equals(selectedOrder.getCustomerID())) {
                    orderList.toArray()[i].setCustomerName(txtName.getText());
                }
            }
//            selectedOrder.setCustomerName(txtName.getText());
        }
        if (!selectedOrder.getOrderStatus().equals((String) comboBoxStatus.getSelectedItem())) {
            needToUpdate = true;
            selectedOrder.setOrderStatus((String) comboBoxStatus.getSelectedItem());
        }
        if (selectedOrder.getQuantity() != Integer.parseInt(txtQty.getText())) {
            needToUpdate = true;
            selectedOrder.setQuantity(Integer.parseInt(txtQty.getText()));
        }

        if (!needToUpdate) {
            JOptionPane.showMessageDialog(
                    UpdateOrderPanel.this,
                    "Nothing to update",
                    "Invalid Action",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            StorageManager.refreshStorage(orderList);
            JOptionPane.showMessageDialog(
                    UpdateOrderPanel.this,
                    "Successfully Updated",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE
            );

            reset();
            txtOrderId.setText("");
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void comboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxStatusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblErr;
    private javax.swing.JTextField txtCustomerId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtOrderId;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
