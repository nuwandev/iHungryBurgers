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
import models.OrderList;
import utils.StorageManager;

class MainFrame extends JFrame {

    private JPanel cards;
    private final OrderList orderList;

    public MainFrame() {
        setTitle("iHungry Burgers Shop");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);    
        setResizable(false);

        cards = new JPanel(new CardLayout());
        this.orderList = StorageManager.loadOrderList();

        cards.add(new HomePanel(this), "HOME");
        cards.add(new PlaceOrderPanel(this, orderList), "PLACE_ORDER");
        cards.add(new SearchBestCustomerPanel(this, orderList), "BEST_CUSTOMER");
        cards.add(new SearchOrderPanel(this, orderList), "SEARCH_ORDER");
        cards.add(new SearchCustomerPanel(this, orderList), "SEARCH_CUSTOMER");
        cards.add(new ViewOrdersPanel(this), "VIEW_ORDERS");
        cards.add(new PendingOrdersPanel(this, orderList), "PENDING_ORDERS");
        cards.add(new PreparingOrdersPanel(this, orderList), "PREPARING_ORDERS");
        cards.add(new DeliveredOrdersPanel(this, orderList), "DELIVERED_ORDERS");
        cards.add(new CancelledOrdersPanel(this, orderList), "CANCELLED_ORDERS");
        cards.add(new UpdateOrderPanel(this, orderList), "UPDATE_ORDERS");

        add(cards);

        setVisible(true);
        System.out.println(this.getPreferredSize());
    }

    public void showCard(String name) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, name);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
