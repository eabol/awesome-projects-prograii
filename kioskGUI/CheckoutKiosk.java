import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CheckoutKiosk extends JFrame {
    private ProductList productList;
    private DiscountList discountList;
    private JList<String> productJList;
    private JTextArea totalPriceTextArea;
    private JTextField discountCodeField;
    private ArrayList<Product> selectedProducts;
    private JLabel messageLabel;

    public CheckoutKiosk() {
        productList = new ProductList();
        discountList = new DiscountList();
        selectedProducts = new ArrayList<>();
        setupGUI();
    }

    private void setupGUI() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        messageLabel = new JLabel("");
        add(messageLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new CardLayout());
        add(mainPanel, BorderLayout.CENTER);

        JPanel welcomePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to the self checkout kiosk!");
        JButton nextButton = new JButton("Next");

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.next(mainPanel);
            }
        });

        welcomePanel.add(welcomeLabel);
        welcomePanel.add(nextButton);

        JPanel productListPanel = new JPanel();
        productJList = new JList<>();
        JButton nextButton2 = new JButton("Next");

        nextButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            for (String productInfo : productJList.getSelectedValuesList()) {
                String productName = productInfo.split(":")[0].trim();
                Product product = productList.getItemByName(productName);
                if (product != null) {
                    selectedProducts.add(product);
                }
            }
            CardLayout cl = (CardLayout) mainPanel.getLayout();
            cl.next(mainPanel);
    }
        });

        productListPanel.add(new JScrollPane(productJList));
        productListPanel.add(nextButton2);

        JPanel discountPanel = new JPanel();
        discountCodeField = new JTextField(10);
        JButton applyDiscountButton = new JButton("Apply Discount");
        JButton nextButton3 = new JButton("Next");

        applyDiscountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String discountCode = discountCodeField.getText();
                Discount discount = discountList.getItem(discountCode);
                if (discount != null) {
                    for (Product product : selectedProducts) {
                        product.applyDiscount(discount);
                    }
                    messageLabel.setText("Discount applied successfully!");
                } else {
                    messageLabel.setText("Error: Invalid discount code");
                }
            }
        });

        nextButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) mainPanel.getLayout();
                cl.next(mainPanel);
            }
        });

        discountPanel.add(new JLabel("Enter discount code: "));
        discountPanel.add(discountCodeField);
        discountPanel.add(applyDiscountButton);
        discountPanel.add(nextButton3);

        JPanel totalPricePanel = new JPanel();
        totalPriceTextArea = new JTextArea(5, 20);
        JButton finishButton = new JButton("Finish");

        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!selectedProducts.isEmpty()) {
                    double total = 0;
                    for (Product product : selectedProducts) {
                        total += product.getPrice();
                    }
                    totalPriceTextArea.setText("Total price: " + total);
                    messageLabel.setText("");
                } else {
                    messageLabel.setText("Error: No products selected");
                }
            }
        });

        totalPricePanel.add(new JScrollPane(totalPriceTextArea));
        totalPricePanel.add(finishButton);

        mainPanel.add(welcomePanel, "WELCOME_PANEL");
        mainPanel.add(productListPanel, "PRODUCT_LIST_PANEL");
        mainPanel.add(discountPanel, "DISCOUNT_PANEL");
        mainPanel.add(totalPricePanel, "TOTAL_PRICE_PANEL");

        setVisible(true);
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
