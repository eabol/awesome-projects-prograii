package main;

import java.util.Scanner;

public class Game implements View {
    private Board board;
    private Turn turn;
    private Scanner scanner;

    public Game(Board board, Scanner scanner) {
        this.board = board;
        this.scanner = scanner;
        turn = new Turn();
    }

    public Game(Board board) {
        this(board, null);
        turn = new Turn();
    }

    public Game() {
        this(new Board(10, 10), null);
        turn = new Turn();
    }

    public void showMenu() {
        System.out.println("WELCOME TO WHACK-A-MOLE");
    }

    public void startToPlay() {
        scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        while (continuePlaying) {
            board.showBoard();

            System.out.println("Select a hole to hit:");
            int position = scanner.nextInt();

            int rows = board.getRowCount();
            int columns = board.getColumnCount();

            if (position >= 0 && position < rows * columns) {
                int row = position / columns;
                int column = position % columns;

                Hole hole = board.getHole(row, column);
                hole.setAspect("Hit");

                System.out.println("Hit at position " + position);

                System.out.println("Do you want to continue playing? (Y/N)");
                String choice = scanner.next();

                if (choice.equalsIgnoreCase("N")) {
                    continuePlaying = false;
                }
            } else {
                System.out.println("Invalid hole position. Please try again.");
            }
        }

        endPlaying();
    }

    private void endPlaying() {
        System.out.println("Game over!");
    }

    public static void main(String[] args) {
        Board board = new Board(3, 4);
        Game game = new Game(board);
        game.showMenu();
        game.startToPlay();
    }
}