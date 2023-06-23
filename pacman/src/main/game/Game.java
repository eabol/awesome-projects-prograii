package main.game;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import main.renderer.Renderer;

public class Game {
    private Maze maze;
    private Pacman pacman;
    private List<Ghost> ghosts;
    private boolean isRunning = false;
    private int score = 0;
    private int foodCount = 0;
    private Timer pacmanTimer;
    private Timer ghostTimer;
    private int lives;

    public Game() {
        createMaze();
        this.pacman = new Pacman(22, 13);
        this.ghosts = List.of(new Ghost(11, 13), new Ghost(12, 13), new Ghost(15, 13), new Ghost(16, 13));
        this.lives = 3; // Número de vidas inicial
    }

    public int getLives() {
        return lives;
    }

    public List<Ghost> getGhosts() {
        return ghosts;
    }

    public void start() {
        this.isRunning = true;
        this.foodCount = maze.getFoodCount();
    }

    public void stop() {
        this.isRunning = false;
    }

    public void restart() {
        createMaze();
        this.pacman = new Pacman(22, 13);
        this.ghosts = List.of(new Ghost(10, 13), new Ghost(12, 13), new Ghost(15, 13), new Ghost(16, 13));
        this.score = 0;
        this.lives = 3;
    }

    public void handleKeyPress(Character character, Renderer renderer) {
        try {
            switch (character) {
                case 'p':
                    renderer.close();
                    break;
                case 'a':
                    if (pacman.getDirection() != Direction.LEFT)
                        startAutomaticMovement(Direction.LEFT, renderer);
                    break;
                case 'd':
                    if (pacman.getDirection() != Direction.RIGHT)
                        startAutomaticMovement(Direction.RIGHT, renderer);
                    break;
                case 'w':
                    if (pacman.getDirection() != Direction.UP)
                        startAutomaticMovement(Direction.UP, renderer);
                    break;
                case 's':
                    if (pacman.getDirection() != Direction.DOWN)
                        startAutomaticMovement(Direction.DOWN, renderer);
                    break;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void startAutomaticMovement(Direction direction, Renderer renderer) {

        stopPacmanMovement();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Position nextCellPosition = pacman.getNextPosition(direction);

                if (maze.getCell(nextCellPosition) == null
                        || maze.getCell(nextCellPosition).isWall()) {
                    if (direction == pacman.getDirection()) {
                        // TODO
                    }
                    pacmanTimer.cancel();
                    pacmanTimer = null;
                    pacman.setDirection(null);
                    return;
                } else if (maze.getCell(nextCellPosition).isFood()) {
                    maze.updateCell(new Cell(nextCellPosition, CellType.EMPTY));
                    score++;
                }
                try {
                    renderer.movePacman(pacman.move(direction));
                    if (score == foodCount) {
                        stopPacmanMovement();
                        stopGhostMovement();
                        renderer.printWinScreen();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        this.pacmanTimer = new Timer();
        this.pacmanTimer.schedule(timerTask, 0, 300);
    }

    private void stopPacmanMovement() {
        if (this.pacmanTimer != null) {
            this.pacmanTimer.cancel();
            this.pacmanTimer = null;
        }
    }

    public void startGhostMovement(Renderer renderer) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    for (Ghost ghost : ghosts) {
                        renderer.moveGhost(ghost, ghost.chasePacman(pacman, maze, ghosts));
                        checkCollision(renderer);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        this.ghostTimer = new Timer();
        this.ghostTimer.schedule(timerTask, 0, 500);
    }

    private void stopGhostMovement() {
        if (this.ghostTimer != null) {
            this.ghostTimer.cancel();
            this.ghostTimer = null;
        }
    }

    private void checkCollision(Renderer renderer) {
        for (Ghost ghost : ghosts) {
            if (Position.isEqual(pacman.getPosition(), ghost.getPosition())) {
                loseLife(renderer);
                break;
            }
        }
    }

    private void loseLife(Renderer renderer) {
        try {
            lives--;
            pacman.setPosition(new Position(22, 13));
            renderer.movePacman(pacman.getPosition());
            if (lives <= 0) {
                stopPacmanMovement();
                stopGhostMovement();
                renderer.printWinScreen();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update() {
        // Lógica para actualizar el estado del juego
    }

    public Maze getMaze() {
        return maze;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private void createMaze() {
        int[][] map = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 2, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 4, 2, 2, 1, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 2, 2, 4, 1 },
                { 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1 },
                { 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
        this.maze = new Maze(map);
    }
}