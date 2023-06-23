import Points.Droweable;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de las clases principales
        Map map = new Map; /* aqui iria la matriz del mapa pero no tengo ni idea que poner, no me queda muy claro*/;
        PacMan pacMan = new PacMan();
        Ghost ghost = new RandomGhost(10, 10);
        Food food = new Food(5, 5);
        PowerUp powerUp = new PowerUp(8, 8);

        // Mostrar el mapa inicial
        map.Draw();

        // Mostrar la posición inicial de PacMan, el fantasma, la comida y el PowerUp
        drawObjects(pacMan, ghost, food, powerUp);

        // Ejemplo de movimiento de PacMan y el fantasma
        pacMan.movement("d", map);
        ghost.movement(pacMan, map);

        // Mostrar el estado después del movimiento
        map.Draw();
        drawObjects(pacMan, ghost, food, powerUp);
    }

    // Método auxiliar para dibujar los objetos en el mapa
    private static void drawObjects(Droweable... objects) {
        for (Droweable object : objects) {
            object.Draw();
        }
        System.out.println();
    }
}