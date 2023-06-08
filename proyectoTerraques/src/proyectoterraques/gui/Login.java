package proyectoterraques.gui;

import proyectoterraques.exceptions.InvalidCharacterException;
import proyectoterraques.source.Bank;
import proyectoterraques.source.FileHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws InvalidCharacterException {


        Scanner scNumber = new Scanner(System.in);
        Scanner scText = new Scanner(System.in);
        FileHandler file = new FileHandler();


        int option;
        String path;
        int menuOption=0;

        ArrayList<String> offices_available= new ArrayList<>();
        ArrayList<String> countries_available= new ArrayList<>();

        Bank bank=null;


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

                for (String currentBank: file.loadFileContent(path)){

                    String [] cell;
                    cell= currentBank.split(",");

                    String office=cell[0];
                    String address=cell[1];
                    String city=cell[2];
                    String countryName=cell[3];
                    String country=cell[4];


                    System.out.println(office+"\t\t"+address+"\t\t"+countryName+"\t\t"+country+"\t\t"+city);
                    bankNumber++;
                    offices_available.add(office);
                    countries_available.add(country);
                    /*Client tempClient = new Client(name,surName,address,phone);
                    clients.add(tempClient);
                    numeroClientes++;*/
                }


                file.clear();

                boolean mustLogin=false;

                System.out.print("\nChoose an office number: ");
                office_selected=scNumber.next();

                for (int i=0;i<offices_available.size();i++){

                    if (office_selected.equalsIgnoreCase(offices_available.get(i))){
                        mustLogin=true;
                        bank = new Bank(offices_available.get(i),countries_available.get(i));
                    }

                }

                if (mustLogin){



                    //todo LOGIN

                    System.out.println("\n-------LOGIN--------");
                    System.out.print("User: ");
                    user_selected = scText.next();
                    System.out.print("Password: ");
                    password_selected = scText.next();

                    System.out.println();

                    //todo leer archivo employees.dat

                    path="src/proyectoterraques/files/employees.dat";

                    for (String currentEmployee: file.loadFileContent(path)){

                        String [] cell;
                        cell= currentEmployee.split(",");

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
                                System.out.println("Connecting...");

                                //todo MENU

                                do{

                                    System.out.println("\n--SANTANDER BANK--");
                                    System.out.println("1 - New Client");
                                    System.out.println("2 - New Account");
                                    System.out.println("3 - Show Client");
                                    System.out.println("4 - Show Account");
                                    System.out.println("5 - Deposit");
                                    System.out.println("6 - Withdraw");
                                    System.out.println("7 - List Clients");
                                    System.out.println("8 - List Accounts");
                                    System.out.println("9 - Remove Client");
                                    System.out.println("10 - Remove Account");
                                    System.out.println("11 - Exit\n");

                                    System.out.print("Choose an option: ");
                                    menuOption= scNumber.nextInt();

                                    if (menuOption==1){

                                        System.out.println("");
                                        bank.newClient();

                                    } else if (menuOption==2) {

                                        System.out.println("");
                                        bank.newAccount();

                                    }else if (menuOption==3) {

                                        System.out.println("");
                                        bank.showClient();


                                    }else if (menuOption==4) {

                                        System.out.println("");
                                        bank.showAccount();

                                    }else if (menuOption==5) {

                                        System.out.println("");
                                        bank.depositMoney();

                                    }else if (menuOption==6) {

                                        System.out.println("");
                                        bank.withDrawMoney();

                                    }else if (menuOption==7) {

                                        System.out.println("");
                                        bank.getClients();

                                    }else if (menuOption==8) {

                                        System.out.println("");
                                        bank.getAccounts();


                                    }else if (menuOption==9) {

                                        System.out.println("");
                                        bank.removeClient();


                                    }else if (menuOption==10) {

                                        System.out.println("");
                                        bank.removeAccount();


                                    }else if (menuOption==11) {

                                        System.out.println("");
                                        System.out.println("Exiting...");

                                    }else {

                                        System.out.println("");
                                        System.out.println("¡Invalid option!");

                                    }


                                }while(menuOption!=11);

                            }

                        }

                    }

                    file.clear();

                    if(!userFound){

                        System.out.println("Invalid user or password");

                    }

                    //System.out.println("\n"+employeeNumber+" employees loaded");


                }else{
                    System.out.println("Invalid office number");
                }


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
