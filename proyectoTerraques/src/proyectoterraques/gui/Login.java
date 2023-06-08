package proyectoterraques.gui;

import proyectoterraques.source.FileHandler;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {


        Scanner scNumber = new Scanner(System.in);
        Scanner scText = new Scanner(System.in);
        FileHandler file = new FileHandler();


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

                int bankNumber=0;
                int employeeNumber=0;
                String office_selected;
                String user_selected;
                String password_selected;
                boolean userFound=false;


                System.out.println("\nOFFICE\t\tOFFICE FULL ADDRESS\t\tCOUNTRY\t\tCODE\tCITY");
                System.out.println("------------------------------------------------------------------");

                path="src/proyectoterraques/files/banks.dat";

                for (String bank: file.loadFileContent(path)){

                    String [] cell;
                    cell= bank.split(",");

                    String office=cell[0];
                    String address=cell[1];
                    String city=cell[2];
                    String countryName=cell[3];
                    String country=cell[4];


                    System.out.println(office+"\t\t"+address+"\t\t"+countryName+"\t\t"+country+"\t\t"+city);
                    bankNumber++;
                    /*Client tempClient = new Client(name,surName,address,phone);
                    clients.add(tempClient);
                    numeroClientes++;*/
                }

                file.lines.clear();

                System.out.print("\nChoose an office number: ");
                office_selected=scNumber.next();

                //todo LOGIN

                System.out.println("\n-------LOGIN--------");
                System.out.print("User: ");
                user_selected = scText.next();
                System.out.print("Password: ");
                password_selected = scText.next();

                System.out.println();

                //todo leer archivo employees.dat

                path="src/proyectoterraques/files/employees.dat";

                for (String employee: file.loadFileContent(path)){

                    String [] cell;
                    cell= employee.split(",");

                    String office=cell[0];
                    String user=cell[1];
                    String password=cell[2];
                    String name=cell[3];
                    String dni=cell[4];


                    //System.out.println(office+"\t\t"+user+"\t\t"+password+"\t\t"+name+"\t\t"+dni);
                    employeeNumber++;
                    /*Client tempClient = new Client(name,surName,address,phone);
                    clients.add(tempClient);
                    numeroClientes++;*/

                    if(office_selected.equalsIgnoreCase(office)){

                        if(user_selected.equalsIgnoreCase(user) && password_selected.equalsIgnoreCase(password)){

                            userFound=true;
                            System.out.println("User found");

                            //todo MENU

                        }

                    }

                }

                file.lines.clear();

                if(!userFound){

                    System.out.println("Invalid user or password");

                }

                //System.out.println("\n"+employeeNumber+" employees loaded");




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
