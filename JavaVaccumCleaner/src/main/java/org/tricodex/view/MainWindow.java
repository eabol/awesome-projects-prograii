package org.tricodex.view;

import javax.swing.*;

public class MainWindow extends JFrame {
    //private ImageIcon ICON = new ImageIcon("src/main/resources/icon.png");
    public MainWindow() {
        super("Vacuum Cleaner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setIconImage(ICON.getImage());

        GamePanel gamePanel = new GamePanel();
        add(gamePanel);
        add(gamePanel);

        pack();

        setLocationRelativeTo(null);
        setVisible(true);

        gamePanel.startGameThread();
        gamePanel.run();
    }
}
