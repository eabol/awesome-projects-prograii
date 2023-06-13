package Vacuum;

public class AspiradoraMain {


    public static void main(String[] args) {
        Board board = new Board(10, 25);
        board.generateMap();
        board.printMap();
        board.addFurnitures();

    }




}

