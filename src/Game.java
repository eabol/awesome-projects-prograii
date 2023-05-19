package src;
import src.entity.Player;
import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable{
        public final int originalSize = 68;
        final int maxScreenRow = 7;
        final int maxScreenCol = 12;
        final int screenWidth = maxScreenCol * originalSize;
        final int screenHeight = maxScreenRow * originalSize;

int FPS = 60;
public long drawCount = 0;


        KeyHandler keyHandler = new KeyHandler();
        Thread gameThread;
        Player player = new Player(this, keyHandler);

        int playerX = 100;
        int playerY = 100;
        int playerSpeed = 2;
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
                double delta = 0;
                long lastDrawTime = System.nanoTime();
                long currentTime;
                double drawInterval = 1000000000 / FPS;
                long timer = 0;
                //double nextDrawTime = System.nanoTime() + drawInterval;

                while(gameThread != null) {
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
                        update();
                        repaint();

                        try {
                                double remainingTime = nextDrawTime - System.nanoTime();
                                remainingTime = remainingTime / 1000000;
                                if (remainingTime < 0){
                                        remainingTime = 0;
                                }

                                Thread.sleep((long)remainingTime);
                                nextDrawTime += drawInterval;

                        } catch (InterruptedException e) {
                                e.printStackTrace();
                        }
                        */
                }
        }

        public void update() {
                player.update();
        }
        public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                player.draw(g2d);
                g2d.dispose();
                //g2d.setColor(Color.black);
                //g2d.fillRect(0, 0, screenWidth, screenHeight);
                //g2d.setColor(Color.white);
                //g2d.drawString("Hola", 100, 100);
        }

}
