package view;

import core.Time;
import core.character.KeyHandler;
import core.character.PlayerDrawer;
import core.character.Player;
import core.collision.CollisionChecker;
import view.assets.ImageLoader;
import view.assets.ImagePainter;

import javax.swing.*;
import java.awt.*;

public class WorldHandler extends JPanel implements Runnable {
        public final int originalSize = 84;
        private Time time;
        final int maxScreenRow = 10;
        final int maxScreenCol = 20;
        public final int screenWidth = maxScreenCol * originalSize;
        public final int screenHeight = maxScreenRow * originalSize;
        public final int characterWidth = 48;
        public final int characterHeight = 64;
        int FPS = 60;
        public TileManager tileManager = new TileManager(this);
        public CollisionChecker getCollisionChecker() {
                return collisionChecker;
        }
        public CollisionChecker collisionChecker = new CollisionChecker(this);
        public long drawCount = 0;
        public final int maxWorldCol = 50;
        public final int maxWorldRow = 50;
        public final int worldWidth = maxWorldCol * originalSize;
        public final int worldHeight = maxWorldRow * originalSize;
        Thread gameThread;
        KeyHandler keyHandler = new KeyHandler();
        PlayerDrawer player = new Player(this, keyHandler);
        ImageLoader imageLoader = new ImageLoader();
        ImagePainter imagePainter = new ImagePainter(imageLoader);
        public int getScreenWidth() {return screenWidth;}
        public int getScreenHeight() {return screenHeight;}
        public int getCharacterWidth() {return characterWidth;}
        public int getCharacterHeight() {return characterHeight;}
        public int getOriginalSize() {
                return originalSize;
        }
        public int getMaxWorldRow() {
                return maxWorldRow;
        }
        public PlayerDrawer getPlayer() {
                return player;
        }
        public int getMaxWorldCol() {
                return maxWorldCol;
        }
        public WorldHandler() {
                int[][] arrayToTransform = tileManager.getMapTileNum();
                String[][] arrayTransform;
                arrayTransform = new String[arrayToTransform.length][arrayToTransform[0].length];
                for (int i = 0; i < arrayToTransform.length; i++) {
                        for (int j = 0; j < arrayToTransform[0].length; j++) {
                                arrayTransform[i][j] = String.valueOf(arrayToTransform[i][j]);
                        }
                }
                //String[][][] worldData = { arrayTransform };
                /*this.world = new World(worldData);*/
                this.setPreferredSize(new Dimension(screenWidth, screenHeight));
                this.setBackground(Color.black);
                this.setDoubleBuffered(true);
                this.addKeyListener(keyHandler);
                this.setFocusable(true);
        }

        public void startGameThread() {
                gameThread = new Thread(this);
                gameThread.start();
                this.time = new Time(6, 0, 15);
        }

        @Override
        public void run() {
                double delta = 0;
                long lastDrawTime = System.nanoTime();
                long currentTime;
                double drawInterval = 1000000000 / FPS;
                long timer = 0;
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
                                drawCount = 0;
                                timer = 0;
                        }
                }
        }

        public void update() {
                player.update();
                time.advanceTime();
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                tileManager.draw(g2d);
                imagePainter.paintPlayer(g2d, (Player) player, characterWidth, characterHeight);
                g2d.dispose();
        }
}