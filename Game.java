import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable {
        final int originalSize = 100;
        final int maxScreenRow = 12;
        final int maxScreenCol = 18;
        final int screenWidth = maxScreenCol * originalSize;
        final int screenHeight = maxScreenRow * originalSize;

        int FPS = 60;
        KeyHandler keyHandler = new KeyHandler();
        Thread gameThread;

        int playerX = 100;
        int playerY = 100;
        int playerSpeed = 4;

        public Game() {
                this.setPreferredSize(new Dimension(screenWidth, screenHeight));
                this.setBackground(Color.black);
                this.setDoubleBuffered(true);
                this.addKeyListener(keyHandler);
                this.setFocusable(true);
        }

        public void startGameThread() {
                gameThread = new Thread(this);
                gameThread.start();
        }

        @Override
        public void run() {
                double drawInterval = 1000000000 / FPS;
                double delta = 0;
                long lastDrawTime = System.nanoTime();
                long currentTime;
                long timer = 0;
                long drawCount = 0;
                // double nextDrawTime = System.nanoTime() + drawInterval;

                while (gameThread != null) {
                        currentTime = System.nanoTime();
                        delta += (currentTime - lastDrawTime) / drawInterval;
                        timer += currentTime - lastDrawTime;
                        lastDrawTime = currentTime;
                        if (delta >= 1) {
                                update();
                                repaint();
                                delta--;
                                drawCount++;
                        }
                        if (timer >= 1000000000) {
                                System.out.println("FPS: " + drawCount);
                                drawCount = 0;
                                timer = 0;
                        }
                        /*
                         * update();
                         * repaint();
                         * 
                         * try {
                         * double remainingTime = nextDrawTime - System.nanoTime();
                         * remainingTime = remainingTime / 1000000;
                         * if (remainingTime < 0){
                         * remainingTime = 0;
                         * }
                         * 
                         * Thread.sleep((long)remainingTime);
                         * nextDrawTime += drawInterval;
                         * 
                         * } catch (InterruptedException e) {
                         * e.printStackTrace();
                         * }
                         */
                }
        }

        public void update() {
                if (keyHandler.upPressed) {
                        playerY -= playerSpeed;
                } else if (keyHandler.downPressed) {
                        playerY += playerSpeed;
                } else if (keyHandler.leftPressed) {
                        playerX -= playerSpeed;
                } else if (keyHandler.rightPressed) {
                        playerX += playerSpeed;
                }
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.white);
                g2d.fillRect(playerX, playerY, originalSize, originalSize);
                g2d.dispose();
                // g2d.setColor(Color.black);
                // g2d.fillRect(0, 0, screenWidth, screenHeight);
                // g2d.setColor(Color.white);
                // g2d.drawString("Hola", 100, 100);
        }

}
