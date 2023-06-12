package main;

import java.util.Scanner;

public class Game implements View{
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
        this(new Board(), null);
        turn = new Turn();
    }

    public void showMenu() {
        View.showMenu();
    }

    public void startToPlay() {
        scanner = new Scanner(System.in);
        boolean continuePlaying = true;

        while (continuePlaying) {
            board.showBoard();

            System.out.println("Select a hole to hit:");
            int position = scanner.nextInt();

            if (position >= 0 && position < board.getTotalHoles()) {
                Hole hole = board.beatenHole(position);
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
        Game game = new Game();
        game.showMenu();
        game.startToPlay();
    }

}