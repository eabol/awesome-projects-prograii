import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckoutKiosk extends JFrame {
    private ProductList productList;
    private DiscountList discountList;
    private JList<String> productJList;
    private JList<String> cartJList;
    private JLabel totalPriceLabel;
    private JTextField discountCodeField;
    private ArrayList<Product> selectedProducts;
    private JLabel messageLabel;
    private DefaultListModel<String> cartModel;
    private JLabel cartTotalLabel;
    private JLabel discountValueLabel;
    private JLabel newTotalLabel;

    public CheckoutKiosk() {
        productList = new ProductList();
        discountList = new DiscountList();
        selectedProducts = new ArrayList<>();
        setupGUI();
    }

    private void setupGUI() {
        setSize(720, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a main panel with CardLayout.
        JPanel mainPanel = new JPanel(new CardLayout());
        add(mainPanel, BorderLayout.CENTER);

        JPanel welcomePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to the self checkout kiosk!");
        JButton startButton = new JButton("Start");

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
        JButton addToCartButton = new JButton("Add to cart");
        
        cartTotalLabel = new JLabel("Cart total: ");
        JButton checkoutButton = new JButton("Checkout");

        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (String productInfo : productJList.getSelectedValuesList()) {
                    String productName = productInfo.split(":")[0].trim();
                    Product product = productList.getItemByName(productName);
                    if (product != null) {
                        selectedProducts.add(product);
                        cartModel.addElement(product.getName() + ": " + product.getPrice());
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
        shopPanel.add(cartTotalLabel, BorderLayout.SOUTH);
        shopPanel.add(checkoutButton, BorderLayout.SOUTH);

        JPanel checkoutPanel = new JPanel();
        discountCodeField = new JTextField(10);
        JButton applyDiscountButton = new JButton("Apply Discount");
        discountValueLabel = new JLabel("Discount value: ");
        newTotalLabel = new JLabel("New total: ");
        JButton confirmButton = new JButton("Confirm");

        applyDiscountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String discountCode = discountCodeField.getText();
                Discount discount = discountList.getItem(discountCode);
                if (discount != null) {
                    for (Product product : selectedProducts) {
                        product.applyDiscount(discount);
                    }
                    discountValueLabel.setText("Discount value: " + discount.getDiscountValue());
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

        checkoutPanel.add(new JLabel("Enter discount code: "));
        checkoutPanel.add(discountCodeField);
        checkoutPanel.add(applyDiscountButton);
        checkoutPanel.add(discountValueLabel);
        checkoutPanel.add(newTotalLabel);
        checkoutPanel.add(confirmButton);

        JPanel thankYouPanel = new JPanel();
        JLabel thankYouLabel = new JLabel("Thank you for shopping!");
        JButton exitButton = new JButton("Exit");

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

    private void updateCartTotal() {
        double total = 0;
        for (Product product : selectedProducts) {
            total += product.getPrice();
        }
        cartTotalLabel.setText("Cart total: " + total);
        newTotalLabel.setText("New total: " + total);
    }

    public void addProduct(Product product) {
        productList.addItem(product);
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Product p : productList.itemList) {
            model.addElement(p.getName() + ": " + p.getPrice());
        }
        productJList.setModel(model);
    }

    public void addDiscount(Discount discount) {
        discountList.addItem(discount);
    }
}
