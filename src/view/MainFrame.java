/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author TN_Master
 */
import controller.OrderController;
import view.panels.DeliveredOrdersPanel;
import view.panels.PendingOrdersPanel;
import view.panels.SearchBestCustomerPanel;
import view.panels.HomePanel;
import view.panels.UpdateOrderPanel;
import view.panels.ViewOrdersPanel;
import view.panels.PreparingOrdersPanel;
import view.panels.SearchOrderPanel;
import view.panels.CancelledOrdersPanel;
import view.panels.SearchCustomerPanel;
import view.panels.PlaceOrderPanel;
import javax.swing.*;
import java.awt.*;
import model.OrderList;
import storage.StorageManager;

public class MainFrame extends JFrame {

    private JPanel cards;
    private final OrderController orderController;

    public MainFrame() {
        setTitle("iHungry Burgers Shop");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);    
        setResizable(false);

        cards = new JPanel(new CardLayout());
        this.orderController = new OrderController();

        cards.add(new HomePanel(this), "HOME");
        cards.add(new PlaceOrderPanel(this, orderController), "PLACE_ORDER");
        cards.add(new SearchBestCustomerPanel(this, orderController), "BEST_CUSTOMER");
        cards.add(new SearchOrderPanel(this, orderController), "SEARCH_ORDER");
        cards.add(new SearchCustomerPanel(this, orderController), "SEARCH_CUSTOMER");
        cards.add(new ViewOrdersPanel(this), "VIEW_ORDERS");
        cards.add(new PendingOrdersPanel(this, orderController), "PENDING_ORDERS");
        cards.add(new PreparingOrdersPanel(this, orderController), "PREPARING_ORDERS");
        cards.add(new DeliveredOrdersPanel(this, orderController), "DELIVERED_ORDERS");
        cards.add(new CancelledOrdersPanel(this, orderController), "CANCELLED_ORDERS");
        cards.add(new UpdateOrderPanel(this, orderController), "UPDATE_ORDERS");

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
