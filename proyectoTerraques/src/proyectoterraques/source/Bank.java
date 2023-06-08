package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    int accountTenNumbers;
    String office;
    static final String entity = "0049";
    String country;
    int digitControl;
    Scanner scNumber = new Scanner(System.in);
    Scanner scText = new Scanner(System.in);
    List<Client> clients;
    List<Account> accounts;

    public Bank(String office, String country) {
        this.office=office;
        this.country=country;
        clients= new ArrayList<>();
        accounts= new ArrayList<>();
        //TODO leer el archivo accounts.dat y clients.dat y rellenar los arrays
        loadData();
    }

   public void getClients() {

       System.out.println("---CLIENT LIST---");

       for (int i =0;i<clients.size();i++){

           if (clients.get(i) instanceof ShareholderClient){
               System.out.println( ((ShareholderClient)clients.get(i)).getFullData() );
           } else if (clients.get(i) instanceof StandardClient) {
               System.out.println( ((StandardClient)clients.get(i)).getFullData() );
           }

       }
       if(clients.size()==0){
           System.out.println("No clients found\n");
       }

   }

   public void getAccounts() {

           System.out.println("---ACCOUNT LIST---");

        for (int i =0;i<accounts.size();i++){

            if (accounts.get(i) instanceof CreditAccount){
                ((CreditAccount) accounts.get(i)).showAccountData();
            } else if (accounts.get(i) instanceof DebitAccount) {
                ((DebitAccount) accounts.get(i)).showAccountData();
            }

        }
       if(accounts.size()==0){
           System.out.println("No accounts found\n");
       }
   }

   public void newClient() throws InvalidCharacterException {

        //StandardClient cliente = new StandardClient(dni,name,surname,address,phoneNumber);
       int election;

       String dni;
       String name;
       String surname;
       String address;
       String phoneNumber;

       System.out.println("\nCREATE CLIENT");
       System.out.println("1 - Standard");
       System.out.println("2 - Shareholder");
       System.out.print("\nSelect a client type: ");
       election = scNumber.nextInt();
       if (election==1){

           System.out.print("Dni: ");
           dni = scText.nextLine();
           System.out.print("Name: ");
           name = scText.nextLine();
           System.out.print("Surname: ");
           surname = scText.nextLine();
           System.out.print("Address: ");
           address = scText.nextLine();
           System.out.print("Phone Number: ");
           phoneNumber = scText.nextLine();

           StandardClient client = new StandardClient(dni,name,surname,address,phoneNumber);

           //todo
           clients.add(client);
           Account acc = newAccount();

           //boolean remove_acc = client.addAccount(acc);

           //if(remove_acc){
               //todo borrar cuenta creada (acc)
               //for(int i=0;i<accounts.size();i++){
                 //  if(accounts.get(i).accountNumber.equalsIgnoreCase(acc.accountNumber)){
                     //  accounts.remove(i);

                   //}
              // }
           //}else{
              // clients.add(client);

           //}



           //TODO  añadir el cliente al archivo clients.dat

       } else if (election==2){
           System.out.print("Dni: ");
           dni = scText.nextLine();
           System.out.print("Name: ");
           name = scText.nextLine();
           System.out.print("Surname: ");
           surname = scText.nextLine();
           System.out.print("Address: ");
           address = scText.nextLine();
           System.out.print("Phone Number: ");
           phoneNumber = scText.nextLine();

           ShareholderClient client = new ShareholderClient(dni,name,surname,address,phoneNumber);

           clients.add(client);

           Account acc = newAccount();

           //boolean remove_acc = client.addAccount(acc);

          // if(remove_acc){
               //todo borrar cuenta crecreada (acc)
            //   for(int i=0;i<accounts.size();i++){
              //     if(accounts.get(i).accountNumber.equalsIgnoreCase(acc.accountNumber)){
                //       accounts.remove(i);
                       //System.out.println("Cuenta borrada");
                  // }
               //}
           //}else{
              // clients.add(client);
               //System.out.println("yyy");
           //}




           //TODO  añadir el cliente al archivo clients.dat

       }else {
           throw new InvalidCharacterException("Invalid option, only numeric characters allowed");

       }
   }


    public Account newAccount() throws InvalidCharacterException {

        int election;

        //todo leer archivo numberOfAccounts.dat y sacar las cuentas creadas , sumarle 1
        //todo y meterlo en el atributo de clase (accountNumber) y sobreescribimos el archivo con el nuevo valor
        accountTenNumbers=1234567890;
        //TODO  generamos un aleatorio entre 10 y 90 y lo metemos en el atributo digit control
        digitControl=(int)(Math.random()*80+10);
        //TODO  creamos numero de cuenta completo
        String accountNumber=country+" "+ digitControl+" "+entity+" "+office+" "+digitControl+" "+accountTenNumbers;

        System.out.println("\nCREATE ACCOUNT");
        System.out.println("1 - Debit");
        System.out.println("2 - Credit");
        System.out.print("\nSelect an account type: ");
        election = scNumber.nextInt();

        if (election==1){

            System.out.print("Enter client DNI to vinculate: ");
            String dni_selected = scText.next();
            boolean client_found = false;

            for (int i=0; i<clients.size(); i++) {
                if (clients.get(i).getDni().equalsIgnoreCase(dni_selected)){

                    client_found = true;

                    if (clients.get(i) instanceof StandardClient){

                        if(((StandardClient) clients.get(i)).debit_Account==null) {

                            //vincular cuenta

                            DebitAccount tempDebAcc = new DebitAccount(accountNumber);
                            //todo guardamos accountNumber en el archivo numberOfAccounts.dat
                            accounts.add(tempDebAcc);
                            System.out.println("\nDebit account successfully created\n");

                            ((StandardClient) clients.get(i)).addAccount(tempDebAcc);

                            return tempDebAcc;

                        }
                        else {

                            System.out.println("You can't add another debit account to the client\n");
                            return null;

                        }


                    } else if (clients.get(i) instanceof ShareholderClient) {

                        DebitAccount tempDebAcc = new DebitAccount(accountNumber);
                        //todo guardamos accountNumber en el archivo numberOfAccounts.dat
                        accounts.add(tempDebAcc);
                        System.out.println("\nDebit account successfully created\n");

                        ((ShareholderClient) clients.get(i)).addAccount(tempDebAcc);

                        return tempDebAcc;


                    }
                }

            }

            if (!client_found){

                System.out.println("Client not found\n");
                return null;
            }




        } else if (election==2){

            /*

            CreditAccount tempCredAcc = new CreditAccount(accountNumber);
            //todo guardamos accountNumber en el archivo numberOfAccounts.dat
            accounts.add(tempCredAcc);
            System.out.println("\nCredit account successfully created\n");

            return tempCredAcc;
            */

            System.out.print("Enter client DNI to vinculate: ");
            String dni_selected = scText.next();
            boolean client_found = false;

            for (int i=0; i<clients.size(); i++) {
                if (clients.get(i).getDni().equalsIgnoreCase(dni_selected)){

                    client_found = true;

                    if (clients.get(i) instanceof StandardClient){

                        System.out.println("Credit accounts are only for shareholder clients\n");
                        return null;


                    } else if (clients.get(i) instanceof ShareholderClient) {

                        if(((ShareholderClient) clients.get(i)).credit_Account == null) {

                            //vincular
                            CreditAccount tempCredAcc = new CreditAccount(accountNumber);
                            //todo guardamos accountNumber en el archivo numberOfAccounts.dat
                            accounts.add(tempCredAcc);
                            System.out.println("\nCredit account successfully created\n");
                            ((ShareholderClient) clients.get(i)).addAccount(tempCredAcc);
                            return tempCredAcc;

                        }else {

                            System.out.println("You can't add another credit account to the client\n");
                            return null;


                        }

                    }
                }

            }

            if (!client_found){

                System.out.println("Client not found\n");
                return null;
            }

        }else {

            throw new InvalidCharacterException("Invalid option, only numeric characters allowed");

        }


        return null;

    }

    public void removeClient(){

        String dni;
        boolean found=false;

        System.out.print("Enter Client DNI: ");
        dni = scText.next();
        for (int i=0; i<clients.size();i++){
            if (dni.equalsIgnoreCase(clients.get(i).getDni())){
                found=true;

                //todo borrar cuentas asociadas al cliente en el array de cuentas

                //principio
                if(clients.get(i) instanceof StandardClient){
                    for(int j=0;j<accounts.size();j++){
                        if(accounts.get(j).accountNumber.equalsIgnoreCase(((StandardClient) clients.get(i)).debit_Account.accountNumber)){
                            accounts.remove(j);
                        }
                    }
                }
                else if (clients.get(i) instanceof ShareholderClient){
                    for(int j=0;j<accounts.size();j++){
                        if(((ShareholderClient) clients.get(i)).credit_Account!=null){
                            if(accounts.get(j).accountNumber.equalsIgnoreCase(((ShareholderClient) clients.get(i)).credit_Account.accountNumber)){
                                accounts.remove(j);
                            }
                        }
                        else{
                            System.out.println("No credit account inoculated to the client");
                        }
                        if(((ShareholderClient) clients.get(i)).debitAccounts.size()>0){
                            for(int k=0;k<((ShareholderClient) clients.get(i)).debitAccounts.size();k++){
                                if(accounts.get(j).accountNumber.equalsIgnoreCase(((ShareholderClient) clients.get(i)).debitAccounts.get(k).accountNumber)){
                                    accounts.remove(j);
                                }
                            }
                        }
                        else{
                            System.out.println("No debit accounts inoculated to the client");
                        }
                        //todo borrar si esta en las cuentas de debito

                    }
                }

                //fin

                clients.remove(i);

                System.out.println("Client successfully removed\n");
            }
        }
        if (!found){
            System.err.println("Client not found");
        }

    }

    public void removeAccount(){

        String accountNumber;
        boolean found=false;

        System.out.print("Enter Account Number: ");
        accountNumber = scText.nextLine();

        for (int i=0; i<accounts.size();i++){

            if (accountNumber.equalsIgnoreCase(accounts.get(i).getAccountNumber())){
                found=true;
                accounts.remove(i);

                //todo borrar tambien la cuenta del cliente que la tiene

                for(int j=0;j<clients.size();j++){
                    if(clients.get(j) instanceof StandardClient){
                        if(((StandardClient)clients.get(j)).debit_Account!=null){
                            if( ((StandardClient)clients.get(j)).debit_Account.accountNumber.equalsIgnoreCase(accountNumber) ){
                                ((StandardClient)clients.get(j)).debit_Account=null;
                            }
                        }
                        else{
                            System.out.println("No debit account associated to the client");
                        }

                    }
                    else if(clients.get(j) instanceof ShareholderClient){
                        if(((ShareholderClient)clients.get(j)).credit_Account!=null){
                            if( ((ShareholderClient)clients.get(j)).credit_Account.accountNumber.equalsIgnoreCase(accountNumber) ){
                                ((ShareholderClient)clients.get(j)).credit_Account=null;
                            }
                        }
                        else{
                            System.out.println("No credit account associated to the client");
                        }

                        //todo otro if para las de debito con un for
                        if(((ShareholderClient)clients.get(j)).debitAccounts.size()>0){
                            for(int k=0;k<((ShareholderClient)clients.get(j)).debitAccounts.size();k++){
                                if(((ShareholderClient)clients.get(j)).debitAccounts.get(k).accountNumber.equalsIgnoreCase(accountNumber)){
                                    ((ShareholderClient)clients.get(j)).debitAccounts.remove(k);
                                }
                            }
                        }
                        else{
                            System.out.println("No debit accounts associated to the client");
                        }

                    }
                }

                System.out.println("Account successfully removed\n");
            }
        }
        if (!found){
            System.err.println("Account not found");
        }

    }

    public void showClient(){

        String dni;
        boolean found=false;

        System.out.print("Enter Client DNI: ");
        dni = scText.next();

        for (int i=0; i<clients.size();i++){
            if (dni.equalsIgnoreCase(clients.get(i).getDni())){
                found = true;
                if (clients.get(i) instanceof StandardClient){
                    System.out.println(clients.get(i).getFullData());
                    ((StandardClient) clients.get(i)).listAccounts();

                } else if (clients.get(i) instanceof ShareholderClient){
                    System.out.println(clients.get(i).getFullData());
                    ((ShareholderClient) clients.get(i)).listAccounts();
                }
            }
        }
        if (!found){
            System.err.println("Client not found");
        }

    }

    public void showAccount(){

        String accountNumber;
        boolean found=false;

        System.out.print("Enter Account Number: ");
        accountNumber = scText.nextLine();

        for (int i=0; i<accounts.size();i++) {
            if (accountNumber.equalsIgnoreCase(accounts.get(i).getAccountNumber())) {
                found = true;
                if (accounts.get(i) instanceof CreditAccount) {
                    ((CreditAccount) accounts.get(i)).showAccountData();

                } else if (accounts.get(i) instanceof DebitAccount) {
                    ((DebitAccount) accounts.get(i)).showAccountData();
                }
            }
        }
        if (!found){
                System.err.println("Account not found");
        }

    }


    //todo
    public void loadData(){


    }

   public void depositMoney(){

        String accountNumber;
        boolean found=false;

        System.out.print("Enter Account Number: ");
        accountNumber = scText.nextLine();
        for (int i=0;i< accounts.size();i++){

            if (accountNumber.equalsIgnoreCase(accounts.get(i).accountNumber)){
                found =true;

                if (found){
                    double amount=0;
                    System.out.print("Enter quantity to deposit: ");
                    try {
                         amount = scNumber.nextDouble();
                        try {

                            if (accounts.get(i) instanceof CreditAccount){
                                ((CreditAccount) accounts.get(i)).deposit(amount);

                            } else if (accounts.get(i) instanceof DebitAccount){
                                ((DebitAccount) accounts.get(i)).deposit(amount);
                            }

                        }catch (InvalidCharacterException e){
                            System.err.println("Error: "+e);
                        }
                    }catch(Exception e){
                        System.err.println("Only numeric characters allowed");
                    }

                }
            }
        }
        if (!found){
            System.err.println("Account not found");
        }

    }

    public void withDrawMoney(){

        String accountNumber;
        boolean found=false;

        System.out.print("Enter Account Number: ");
        accountNumber = scText.nextLine();
        for (int i=0;i< accounts.size();i++){

            if (accountNumber.equalsIgnoreCase(accounts.get(i).accountNumber)){
                found =true;

                if (found){
                    double amount=0;
                    System.out.print("Enter quantity to withdraw: ");
                    try {
                        amount = scNumber.nextDouble();
                        try {

                            if (accounts.get(i) instanceof CreditAccount){
                                ((CreditAccount) accounts.get(i)).withdraw(amount);

                            } else if (accounts.get(i) instanceof DebitAccount){
                                ((DebitAccount) accounts.get(i)).withdraw(amount);
                            }

                        }catch (InvalidCharacterException e){
                            System.err.println("Error: "+e);
                        }
                    }catch(Exception e){
                        System.err.println("Only numeric characters allowed");
                    }

                }
            }
        }
        if (!found){
            System.err.println("Account not found");
        }

    }
}
