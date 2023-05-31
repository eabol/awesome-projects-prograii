package proyectoterraques.gui;

import proyectoterraques.source.FileHandler;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {


        Scanner scNumber = new Scanner(System.in);


        int option;
        String path;

        do {

            System.out.println("\n--SANTANDER BANK--");
            System.out.println("1 - Login");
            System.out.println("2 - Exit\n");

            System.out.print("Choose an option: ");
            option=scNumber.nextInt();

            if (option==1){
                clearScreen();
                clearConsole();
                //TODO listar bancos
                FileHandler fileHandler = new FileHandler();
                int bankNumber=1;
                String suboption;
                System.out.println("\nOFFICE\t\tOFFICE FULL ADDRESS\t\tCOUNTRY\t\tCODE\tCITY");
                System.out.println("------------------------------------------------------------------");

                path="src/proyectoterraques/files/banks.dat";

                for (String bank: fileHandler.loadFileContent(path)){

                    String [] separarTexto;
                    separarTexto= bank.split(",");

                    String office=separarTexto[0];
                    String address=separarTexto[1];
                    String city=separarTexto[2];
                    String countryName=separarTexto[3];
                    String country=separarTexto[4];


                    System.out.println(office+"\t\t"+address+"\t\t"+countryName+"\t\t"+country+"\t\t"+city);
                    bankNumber++;
                    /*Client tempClient = new Client(name,surName,address,phone);
                    clients.add(tempClient);
                    numeroClientes++;*/
                }

                System.out.print("\nChoose an office number: ");
                suboption=scNumber.next();



            } else if (option==2){
                System.out.println("\nExiting...");
            } else {
                System.out.println("\n¡Invalid option!");
            }

        }while (option!=2);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

}
