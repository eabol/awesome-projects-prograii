package view;

import core.Maze;
import core.World;
import core.Terrain;
import enumerators.TerrainType;
import view.character.*;
import view.collision.CollisionChecker;

import javax.swing.*;
import java.awt.*;

public class WorldHandler extends JPanel implements Runnable {
        public final int originalSize = 84;
        private World world;
        final int maxScreenRow = 10;
        final int maxScreenCol = 20;
        public final int screenWidth = maxScreenCol * originalSize;
        public final int screenHeight = maxScreenRow * originalSize;
        public final int characterWidth = 48;
        public final int characterHeight = 64;
        KeyHandler keyHandler = new KeyHandler();

        int FPS = 60;
        public TileManager tileManager = new TileManager(this);
        public CollisionChecker collisionChecker = new CollisionChecker(this);
        public long drawCount = 0;

        public final int maxWorldCol = 50;
        public final int maxWorldRow = 50;
        public final int worldWidth = maxWorldCol * originalSize;
        public final int worldHeight = maxWorldRow * originalSize;

        Thread gameThread;
        PlayerDrawer player = new PlayerHandler(this, keyHandler);

        public WorldHandler() {
                int[][] arrayToTransform = tileManager.mapTileNum;
                String[][] arrayTransform;
                arrayTransform = new String[arrayToTransform.length][arrayToTransform[0].length];
                for (int i = 0; i < arrayToTransform.length; i++) {
                        for (int j = 0; j < arrayToTransform[0].length; j++) {
                                arrayTransform[i][j] = String.valueOf(arrayToTransform[i][j]);
                        }
                }
                String[][][] worldData = { arrayTransform };
                this.world = new World(worldData);
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
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2d = (Graphics2D) g;

                drawMaze(g);
                tileManager.draw(g2d);
                player.draw(g2d);
                g2d.dispose();

        }

        private void drawMaze(Graphics g) {
                int rows = world.getCurrentMaze().getMapYSize();
                int cols = world.getCurrentMaze().getMapXSize();
                int tileSize = Math.min(getWidth() / cols, getHeight() / rows);

                for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                                g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                        }
                }

        }
}
