package GraphicInterface;

import DataClasses.Product;
import SystemData.InventoryDataBase;
import SystemManagement.CartManager;
import SystemManagement.DiscountsManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckoutKiosk extends JFrame {
    private InventoryDataBase productList;
    private DiscountsManager discountList;
    private JList<String> productJList;
    private JList<String> cartJList;
    private JLabel totalPriceLabel;
    private JTextField discountCodeField;

    public CartManager cartManager;
    private JLabel messageLabel;
    private DefaultListModel<String> cartModel;
    private JLabel cartTotalLabel;
    private JLabel discountValueLabel;
    private JLabel newTotalLabel;
    private JButton applyDiscountButton;


    public CheckoutKiosk() {
        productList = new InventoryDataBase();
        discountList = new DiscountsManager();
        cartManager = new CartManager();
        setupGUI();
        updateInventoryUI();
    }

    private void setupGUI() {
        setSize(720, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new CardLayout());
        add(mainPanel, BorderLayout.CENTER);

        JPanel welcomePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel welcomeLabel = new JLabel("Welcome to CleanCash!", SwingConstants.CENTER);
        JButton startButton = new JButton("Start");
        welcomePanel.add(welcomeLabel, gbc);
        welcomePanel.add(startButton, gbc);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.next(mainPanel);
            }
        });

        welcomePanel.add(welcomeLabel);
        welcomePanel.add(startButton);

        JPanel shopPanel = new JPanel(new BorderLayout());
        productJList = new JList<>();
        productJList.setPrototypeCellValue("Item Name --------------------");
        cartModel = new DefaultListModel<>();
        cartJList = new JList<>(cartModel);
        cartJList.setPrototypeCellValue("Item Name --------------------");
        JButton addToCartButton = new JButton("Add to cart / remove");

        cartTotalLabel = new JLabel("Cart total: ");
        JButton checkoutButton = new JButton("Checkout");

        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (String productInfo : productJList.getSelectedValuesList()) {
                    String productName = productInfo.split(":")[0].trim();
                    Product product = productList.findProduct(productName);
                    if (product != null) {
                        cartManager.add(product);
                        updateInventoryUI();
                        //selectedProducts.add(product);
                        cartModel.addElement(product.getEntityName() + ": " + product.getPrice());
                        updateCartTotal();
                    }
                }
                for (String productInfo : cartJList.getSelectedValuesList()) {
                    String productName = productInfo.split(":")[0].trim();
                    Product product = cartManager.getShoppingCart().findProduct(productName);
                    if (product != null) {
                        cartManager.remove(product);
                        updateInventoryUI();
                        //selectedProducts.add(product);
                        cartModel.removeElement(product.getEntityName() + ": " + product.getPrice());
                        updateCartTotal();
                    }
                }
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.next(mainPanel);
            }
        });

        shopPanel.add(new JScrollPane(productJList), BorderLayout.WEST);
        shopPanel.add(addToCartButton, BorderLayout.CENTER);
        shopPanel.add(new JScrollPane(cartJList), BorderLayout.EAST);
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(cartTotalLabel, BorderLayout.NORTH);
        southPanel.add(checkoutButton, BorderLayout.SOUTH);
        shopPanel.add(southPanel, BorderLayout.SOUTH);

        JPanel checkoutPanel = new JPanel(new GridBagLayout());
        discountCodeField = new JTextField(10);
        applyDiscountButton = new JButton("Apply Discount");
        discountValueLabel = new JLabel("Discount value: ");
        newTotalLabel = new JLabel("New total: ");
        JButton confirmButton = new JButton("Confirm");

        applyDiscountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String discountCode = discountCodeField.getText();
                int discount = discountList.getDiscount(discountCode);
                //Discount discount = discountList.getItem(discountCode);
                if (discount>0) {
                    cartManager.applyDiscount(discount);
                    discountValueLabel.setText("Discount value: " + discount);
                    updateCartTotal();
                    applyDiscountButton.setEnabled(false);
                }
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.next(mainPanel);
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        checkoutPanel.add(new JLabel("Enter discount code: "), c);

        c.gridy++;
        checkoutPanel.add(discountCodeField, c);

        c.gridx++;
        checkoutPanel.add(applyDiscountButton, c);

        c.gridx = 0;
        c.gridy++;
        checkoutPanel.add(discountValueLabel, c);

        c.gridy++;
        checkoutPanel.add(newTotalLabel, c);

        c.gridy++;
        checkoutPanel.add(confirmButton, c);

        JPanel thankYouPanel = new JPanel(new GridBagLayout());
        JLabel thankYouLabel = new JLabel("Thank you for shopping!", SwingConstants.CENTER);
        JButton exitButton = new JButton("Exit");
        thankYouPanel.add(thankYouLabel, gbc);
        thankYouPanel.add(exitButton, gbc);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        thankYouPanel.add(thankYouLabel);
        thankYouPanel.add(exitButton);

        mainPanel.add(welcomePanel, "WELCOME_PANEL");
        mainPanel.add(shopPanel, "SHOP_PANEL");
        mainPanel.add(checkoutPanel, "CHECKOUT_PANEL");
        mainPanel.add(thankYouPanel, "THANK_YOU_PANEL");

        setVisible(true);
    }


    public void updateInventoryUI(){
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Product product : productList.getProducts()) {
            model.addElement(product.getEntityName() + ": " + product.getPrice());
        }
        productJList.setModel(model);
    }

    private void updateCartTotal() {
        cartTotalLabel.setText("Cart total: " + cartManager.getTotalCost());
        newTotalLabel.setText("New total: " + cartManager.getFinalCost());
    }
}

