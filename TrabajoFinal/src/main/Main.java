package Main;

public class Main {
    public static void main(String[] args) {
        World world = new World();

        try {
            world.simulate();
        } catch (Alive e) {
            System.out.println(e.getMessage());
        } catch (Death e) {
            System.out.println(e.getMessage());
        } catch (CameOut e) {
            System.out.println(e.getMessage());
        }
    }
}