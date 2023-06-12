import view.WorldHandler;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Laberinto del Eden");

        WorldHandler world = new WorldHandler();
        window.add(world);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        world.startGameThread();

    }
}