
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Crear una instancia del mapa
        Map map = new Map(28, 31);

        // Crear una instancia de PacMan
        PacMan pacman = new PacMan();

        // Crear una instancia de Ghost
        Ghost ghost = new RandomGhost(14, 11); // Ubicación arbitraria

        // Crear una instancia de Random para generar movimientos aleatorios
        Random random = new Random();

        // Crea un array con las posibles direcciones
        String[] directions = {"w", "a", "s", "d"};

        // Bucle de juego (este es un ejemplo simple, puedes modificarlo según sea necesario)
        for(int i = 0; i < 10; i++){
            // Selecciona una dirección aleatoria
            String direction = directions[random.nextInt(directions.length)];

            // Mueve a PacMan
            pacman.movement(direction, map);

            // Mueve al fantasma
            ghost.movement(pacman, map);

            // Dibuja el mapa
            map.Draw();
        }
    }
}