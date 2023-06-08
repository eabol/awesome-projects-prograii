package view;

import core.Maze;
import core.World;
import core.Terrain;
import enumerators.TerrainType;
import view.character.*;

import javax.swing.*;
import java.awt.*;

public class WorldHandler extends JPanel implements Runnable {
        public final int originalSize = 80;
        private World world;
        final int maxScreenRow = 10;
        final int maxScreenCol = 20;
        public final int screenWidth = maxScreenCol * originalSize;
        public final int screenHeight = maxScreenRow * originalSize;
        KeyHandler keyHandler = new KeyHandler();

        int FPS = 60;
        public long drawCount = 0;

        public final int maxWorldCol = 50;
        public final int maxWorldRow = 50;
        public final int worldWidth = maxWorldCol * originalSize;
        public final int worldHeight = maxWorldRow * originalSize;

        Thread gameThread;
        GameCharacterHandler player = new PlayableGameCharacterHandler(this, keyHandler);

        int playerX = 100;
        int playerY = 100;
        int playerSpeed = 2;
        private static String[][][] mazesData = {
                        {
                                        { "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL",
                                                        "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL",
                                                        "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL",
                                                        "WALL", "WALL", "WALL" },
                                        { "WALL", "TALLGRASS", "TALLGRASS", "TALLGRASS", "TALLGRASS", "TALLGRASS",
                                                        "TALLGRASS", "TALLGRASS", "WALL", "WATER", "WATER", "WATER",
                                                        "TROUBLEDWATER", "WALL", "TROUBLEDWATER", "TROUBLEDWATER",
                                                        "TROUBLEDWATER", "WATER", "WALL", "SAND", "GRASS",
                                                        "MEDIUMGRASS", "TREE", "MEDIUMGRASS", "TREE", "MEDIUMGRASS",
                                                        "MEDIUMGRASS", "WALL" },
                                        { "WALL", "SAND", "WALL", "TALLGRASS", "WALL", "WALL", "WALL", "WALL", "WALL",
                                                        "TALLGRASS", "WATER", "TROUBLEDWATER", "TROUBLEDWATER", "WALL",
                                                        "TROUBLEDWATER", "TROUBLEDWATER", "TROUBLEDWATER", "WATER",
                                                        "WALL", "SAND", "SAND", "WALL", "WALL", "WALL", "MEDIUMGRASS",
                                                        "GRASS", "MEDIUMGRASS", "WALL" },
                                        { "WALL", "SAND", "WALL", "MEDIUMGRASS", "MEDIUMGRASS", "MEDIUMGRASS",
                                                        "MEDIUMGRASS", "MEDIUMGRASS", "MEDIUMGRASS", "WATER", "WALL",
                                                        "WALL", "WALL", "WALL", "TROUBLEDWATER", "TROUBLEDWATER",
                                                        "TROUBLEDWATER", "WATER", "WALL", "WALL", "WALL", "WALL",
                                                        "SAND", "SAND", "SAND", "SAND", "GRASS", "WALL" },
                                        { "WALL", "SAND", "WALL", "WALL", "WALL", "WALL", "WALL", "WATER", "WATER",
                                                        "WATER", "WATER", "TROUBLEDWATER", "TROUBLEDWATER", "WALL",
                                                        "WALL", "TROUBLEDWATER", "TROUBLEDWATER", "WATER", "WALL",
                                                        "SAND", "SAND", "WALL", "SAND", "WATER", "WATER", "WATER",
                                                        "WATER", "WALL" },
                                        { "WALL", "SAND", "WALL", "GRASS", "MEDIUMGRASS", "WALL", "MEDIUMGRASS", "SAND",
                                                        "SAND", "SAND", "WATER", "WATER", "WATER", "WATER", "WALL",
                                                        "WATER", "WATER", "WATER", "SAND", "SAND", "SAND", "WALL",
                                                        "WATER", "WALL", "WALL", "WALL", "WALL", "WALL" },
                                        { "WALL", "SAND", "ROAD", "GRASS", "GRASS", "WALL", "ROAD", "ROAD", "SAND",
                                                        "SAND", "SAND", "WALL", "SAND", "WATER", "WALL", "WATER",
                                                        "SAND", "SAND", "SAND", "SAND", "SAND", "WALL", "WATER",
                                                        "WATER", "WATER", "TROUBLEDWATER", "TROUBLEDWATER", "WALL" },
                                        { "WALL", "ROAD", "ROAD", "ROAD", "ROAD", "WALL", "ROAD", "ROAD", "ROAD",
                                                        "ROAD", "ROAD", "WALL", "ROAD", "SAND", "WALL", "WALL", "WALL",
                                                        "WALL", "SAND", "ROAD", "ROAD", "ROAD", "WATER", "WATER",
                                                        "WATER", "WATER", "TROUBLEDWATER", "WALL" },
                                        { "WALL", "TALLGRASS", "ROAD", "ROAD", "ROAD", "WALL", "ROAD", "WALL", "GRASS",
                                                        "GRASS", "TREE", "WALL", "ROAD", "ROAD", "WALL", "ROAD", "ROAD",
                                                        "ROAD", "ROAD", "TREE", "ROAD", "ROAD", "ROAD", "ROAD", "WATER",
                                                        "WATER", "TROUBLEDWATER", "WALL" },
                                        { "WALL", "TALLGRASS", "ROAD", "GRASS", "GRASS", "WALL", "GRASS", "WALL",
                                                        "GRASS", "TREE", "GRASS", "WALL", "GRASS", "GRASS", "WALL",
                                                        "GRASS", "TREE", "GRASS", "GRASS", "GRASS", "GRASS", "GRASS",
                                                        "ROAD", "SAND", "SAND", "WATER", "WATER", "WALL" },
                                        { "WALL", "TALLGRASS", "WALL", "TREE", "GRASS", "GRASS", "GRASS", "WALL",
                                                        "MEDIUMGRASS", "SAND", "WALL", "WALL", "WALL", "GRASS", "GRASS",
                                                        "GRASS", "GRASS", "WALL", "WALL", "WALL", "WALL", "WALL",
                                                        "ROAD", "WALL", "SAND", "WATER", "WATER", "WALL" },
                                        { "WALL", "WALL", "WALL", "GRASS", "GRASS", "TREE", "GRASS", "WALL", "SAND",
                                                        "TREE", "SAND", "SAND", "WALL", "SAND", "SAND", "SAND", "SAND",
                                                        "WALL", "MEDIUMGRASS", "WALL", "MEDIUMGRASS", "GRASS", "ROAD",
                                                        "WALL", "SAND", "WATER", "WATER", "WALL" },
                                        { "WALL", "TALLGRASS", "WALL", "MEDIUMGRASS", "MEDIUMGRASS", "MEDIUMGRASS",
                                                        "MEDIUMGRASS", "MEDIUMGRASS", "MEDIUMGRASS", "WALL", "SAND",
                                                        "SAND", "WALL", "SAND", "WALL", "SAND", "WALL", "WALL",
                                                        "MEDIUMGRASS", "WALL", "GRASS", "GRASS", "ROAD", "WALL", "SAND",
                                                        "SAND", "WATER", "WALL" },
                                        { "WALL", "TALLGRASS", "ROAD", "MEDIUMGRASS", "MEDIUMGRASS", "TREE",
                                                        "MEDIUMGRASS", "TREE", "MEDIUMGRASS", "WALL", "SAND", "SAND",
                                                        "SAND", "SAND", "WALL", "SAND", "SAND", "WALL", "MEDIUMGRASS",
                                                        "WALL", "MEDIUMGRASS", "GRASS", "ROAD", "WALL", "SAND", "SAND",
                                                        "SAND", "WALL" },
                                        { "WALL", "TALLGRASS", "WALL", "MEDIUMGRASS", "MEDIUMGRASS", "MEDIUMGRASS",
                                                        "MEDIUMGRASS", "MEDIUMGRASS", "MEDIUMGRASS", "WALL", "SAND",
                                                        "WALL", "SAND", "WALL", "WALL", "WALL", "SAND", "WALL",
                                                        "MEDIUMGRASS", "TREE", "GRASS", "GRASS", "ROAD", "WALL", "WALL",
                                                        "WALL", "GRASS", "WALL" },
                                        { "WALL", "WALL", "WALL", "TREE", "TALLGRASS", "TALLGRASS", "TALLGRASS", "TREE",
                                                        "WALL", "TALLGRASS", "WALL", "WALL", "SAND", "SAND", "WALL",
                                                        "WALL", "WALL", "WALL", "GRASS", "GRASS", "WALL", "WALL",
                                                        "WALL", "WALL", "GRASS", "WALL", "MEDIUMGRASS", "WALL" },
                                        { "WALL", "TALLGRASS", "WALL", "TALLGRASS", "TALLGRASS", "TALLGRASS",
                                                        "TALLGRASS", "TALLGRASS", "WALL", "TALLGRASS", "TALLGRASS",
                                                        "WALL", "SAND", "SAND", "SAND", "SAND", "SAND", "WALL", "GRASS",
                                                        "TREE", "GRASS", "GRASS", "ROAD", "WALL", "GRASS", "WALL",
                                                        "MEDIUMGRASS", "WALL" },
                                        { "WALL", "TALLGRASS", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL",
                                                        "TREE", "TALLGRASS", "WALL", "WALL", "WALL", "WALL", "WALL",
                                                        "WALL", "WALL", "GRASS", "GRASS", "MEDIUMGRASS", "MEDIUMGRASS",
                                                        "MEDIUMGRASS", "WALL", "MEDIUMGRASS", "WALL", "GRASS", "WALL" },
                                        { "WALL", "TALLGRASS", "TALLGRASS", "TALLGRASS", "TALLGRASS", "TALLGRASS",
                                                        "TALLGRASS", "TALLGRASS", "TALLGRASS", "TALLGRASS", "TALLGRASS",
                                                        "TALLGRASS", "MEDIUMGRASS", "MEDIUMGRASS", "MEDIUMGRASS",
                                                        "MEDIUMGRASS", "MEDIUMGRASS", "GRASS", "GRASS", "MEDIUMGRASS",
                                                        "MEDIUMGRASS", "MEDIUMGRASS", "MEDIUMGRASS", "WALL",
                                                        "MEDIUMGRASS", "MEDIUMGRASS", "MEDIUMGRASS", "WALL" },
                                        { "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL",
                                                        "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL",
                                                        "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL",
                                                        "WALL", "WALL", "WALL" }
                        }
        };

        public WorldHandler() {
                this.world = new World(mazesData);
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
                player.draw(g2d);

                g2d.dispose();

        }

        private void drawMaze(Graphics g) {
                int rows = world.getCurrentMaze().getMapYSize();
                int cols = world.getCurrentMaze().getMapXSize();
                int tileSize = Math.min(getWidth() / cols, getHeight() / rows);

                for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                                g.setColor(TerrainResolver.solveTerrainColor(
                                                world.getCurrentMaze().getTerrainByPosition(col, row).getType()));
                                g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
                        }
                }

        }
}
