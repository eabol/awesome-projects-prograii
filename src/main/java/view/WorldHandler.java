package src.main.java.view;
import src.main.java.core.Maze;
import src.main.java.core.World;
import src.main.java.core.Terrain;
import src.main.java.enumerators.TerrainType;
import src.main.java.view.character.*;

import javax.swing.*;
import java.awt.*;

public class WorldHandler extends JPanel implements Runnable {
    public final int originalSize = 60;
    private World world;
    final int maxScreenRow = 10;
    final int maxScreenCol = 20;
    public final int screenWidth = maxScreenCol * originalSize;
    public final int screenHeight = maxScreenRow * originalSize;
    KeyHandler keyHandler = new KeyHandler();

    int FPS = 60;
    TileManager tileManager = new TileManager(this);
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
        //double nextDrawTime = System.nanoTime() + drawInterval;

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

    private void drawMaze(Graphics g){
        int rows = world.getCurrentMaze().getMapYSize();
        int cols = world.getCurrentMaze().getMapXSize();
        int tileSize = Math.min(getWidth() / cols, getHeight() / rows);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                g.setColor(TerrainResolver.solveTerrainColor(world.getCurrentMaze().getTerrainByPosition(col, row).getType()));
                g.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
            }
        }

    }
}

