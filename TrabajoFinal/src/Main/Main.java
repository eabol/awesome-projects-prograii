package Main;

public class Main {
    public static void main(String[] args) {
        Well well = new Well();
        try {
            well.survive();
            System.out.println("The Main.Snail survived ");
        } catch (Death e) {
            System.out.println("The Main.Snail died");
        }

    }
}