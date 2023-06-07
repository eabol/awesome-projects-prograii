package org.tricodex.view.windows;

import org.tricodex.view.panels.GamePanel;

import javax.swing.*;

public class MainWindow extends JFrame {
    //private ImageIcon ICON = new ImageIcon("/icon.png");
    public MainWindow(GamePanel gamePanel) {
        super("Vacuum Cleaner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(gamePanel);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

        gamePanel.startGameThread();
    }
}
