import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Map map = new Map();
        PacMan pacMan = new PacMan();
        pacMan.Draw(map);
        RandomGhost ghost = new RandomGhost(10, 10);
        ghost.Draw(map);
        Food food = new Food(5, 5);
        food.Draw(map);
        PowerUp powerUp = new PowerUp(8, 8);
        powerUp.Draw(map);
        map.Draw();
        Scanner input = new Scanner (System.in);

        while(pacMan.isAlive()){

            String usuario_in = input.next();
            pacMan.move(usuario_in,map);
            pacMan.Draw(map);
            map.Draw();
            if(ghost.getX()==pacMan.getX()&&ghost.getY()==pacMan.getY()){
                if(pacMan.isInvencible()==true)
                    pacMan.time_invencible-= pacMan.time_invencible;
                ghost.alive=false;
            }
        }

    }

}