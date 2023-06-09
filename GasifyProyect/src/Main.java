import main.core.menu.MenuOptions;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        System.out.println("Bienvenidos al sistema de Gasify");
        System.out.println("");
        MenuOptions menu = new MenuOptions();
        menu.principalMenu();

    }
}
