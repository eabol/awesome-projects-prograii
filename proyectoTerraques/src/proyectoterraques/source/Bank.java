package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    String accountTenNumbers;

    int accountTenNumbersInt;
    String office;
    static final String entity = "0049";
    String country;
    int digitControl;
    Scanner scNumber = new Scanner(System.in);
    Scanner scText = new Scanner(System.in);
    public List<Client> clients;
    public List<Account> accounts;

    String path;

    String account_data;

    String client_data;

    FileHandler file = new FileHandler();

    FileHandler file2 = new FileHandler();

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

       //System.out.printf("Array clients.size: "+clients.size()+"\n");

       for (int i =0;i<clients.size();i++){

           if (clients.get(i) instanceof ShareholderClient){
               System.out.print( ((ShareholderClient)clients.get(i)).getFullData() );
           } else if (clients.get(i) instanceof StandardClient) {
               System.out.print( ((StandardClient)clients.get(i)).getFullData() );
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

   public void newClient() throws InvalidCharacterException, IOException {

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

           clients.add(client);
           Account acc = newAccount(dni);

           //todo escribir cliente en fichero clients.dat

           String text=dni+","+name+","+surname+","+address+","+phoneNumber+",standard";

           path="src/proyectoterraques/files/clients.dat";

           file.write(path,text);



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

           Account acc = newAccount(dni);

           //todo escribir cliente en fichero clients.dat

           String text=dni+","+name+","+surname+","+address+","+phoneNumber+",shareholder";

           path="src/proyectoterraques/files/clients.dat";

           file.write(path,text);

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


    public Account newAccount() throws InvalidCharacterException, IOException {

        int election;

        //todo leer archivo numberOfAccounts.dat y sacar las cuentas creadas , sumarle 1
        //todo y meterlo en el atributo de clase (accountNumber)

        path="src/proyectoterraques/files/numberOfAccounts.dat";

        for (String acc: file.loadFileContent(path)) {

            String[] cell;
            accountTenNumbers = acc;

        }
        accountTenNumbersInt=Integer.parseInt(accountTenNumbers);

        accountTenNumbersInt++;

        accountTenNumbers=Integer.toString(accountTenNumbersInt);

        //accountTenNumbers=1234567890;
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
            String dni_selected = scText.nextLine();
            boolean client_found = false;

            for (int i=0; i<clients.size(); i++) {
                if (clients.get(i).getDni().equalsIgnoreCase(dni_selected)){

                    client_found = true;

                    if (clients.get(i) instanceof StandardClient){

                        if(((StandardClient) clients.get(i)).debit_Account==null) {

                            //vincular cuenta

                            DebitAccount tempDebAcc = new DebitAccount(accountNumber,dni_selected);

                            //tempDebAcc.dni=dni_selected;

                            //todo guardamos accountNumber en el archivo numberOfAccounts.dat

                            path="src/proyectoterraques/files/numberOfAccounts.dat";

                            file.rewrite(path,accountTenNumbers);

                            accounts.add(tempDebAcc);
                            //System.out.println("\nDebit account successfully created\n");

                            ((StandardClient) clients.get(i)).addAccount(tempDebAcc);

                            //todo escribir cuenta en fichero accounts.dat

                            path="src/proyectoterraques/files/accounts.dat";

                            account_data=accountNumber+","+tempDebAcc.amount+",null,null,"+dni_selected;

                            file.write(path,account_data);

                            return tempDebAcc;

                        }
                        else {

                            System.out.println("You can't add another debit account to the client\n");
                            return null;

                        }


                    } else if (clients.get(i) instanceof ShareholderClient) {

                        DebitAccount tempDebAcc = new DebitAccount(accountNumber, dni_selected);

                        tempDebAcc.dni=dni_selected;

                        //todo guardamos accountNumber en el archivo numberOfAccounts.dat

                        path="src/proyectoterraques/files/numberOfAccounts.dat";

                        file.rewrite(path,accountTenNumbers);

                        accounts.add(tempDebAcc);
                        //System.out.println("\nDebit account successfully created\n");

                        ((ShareholderClient) clients.get(i)).addAccount(tempDebAcc);

                        //todo escribir cuenta en fichero accounts.dat

                        path="src/proyectoterraques/files/accounts.dat";

                        account_data=accountNumber+","+tempDebAcc.amount+",null,null,"+dni_selected;

                        file.write(path,account_data);


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
            String dni_selected = scText.nextLine();
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
                            CreditAccount tempCredAcc = new CreditAccount(accountNumber,dni_selected);

                            tempCredAcc.dni=dni_selected;

                            //todo guardamos accountNumber en el archivo numberOfAccounts.dat

                            path="src/proyectoterraques/files/numberOfAccounts.dat";

                            file.rewrite(path,accountTenNumbers);

                            accounts.add(tempCredAcc);
                            //System.out.println("\nCredit account successfully created\n");
                            ((ShareholderClient) clients.get(i)).addAccount(tempCredAcc);

                            //todo escribir cuenta en fichero accounts.dat

                            path="src/proyectoterraques/files/accounts.dat";

                            account_data=accountNumber+","+tempCredAcc.amount+","+tempCredAcc.debt+","+tempCredAcc.interest+","+dni_selected;

                            file.write(path,account_data);

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

    public Account newAccount(String dni_selected) throws InvalidCharacterException, IOException {

        int election;

        //todo leer archivo numberOfAccounts.dat y sacar las cuentas creadas , sumarle 1
        //todo y meterlo en el atributo de clase (accountNumber)

        path="src/proyectoterraques/files/numberOfAccounts.dat";

        for (String acc: file.loadFileContent(path)) {

            String[] cell;
            accountTenNumbers = acc;

        }
        accountTenNumbersInt=Integer.parseInt(accountTenNumbers);

        accountTenNumbersInt++;

        accountTenNumbers=Integer.toString(accountTenNumbersInt);

        //accountTenNumbers=1234567890;
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


            boolean client_found = false;

            for (int i=0; i<clients.size(); i++) {
                if (clients.get(i).getDni().equalsIgnoreCase(dni_selected)){

                    client_found = true;

                    if (clients.get(i) instanceof StandardClient){

                        if(((StandardClient) clients.get(i)).debit_Account==null) {

                            //vincular cuenta

                            DebitAccount tempDebAcc = new DebitAccount(accountNumber, dni_selected);

                            tempDebAcc.dni=dni_selected;

                            //todo guardamos accountNumber en el archivo numberOfAccounts.dat

                            path="src/proyectoterraques/files/numberOfAccounts.dat";

                            file.rewrite(path,accountTenNumbers);

                            accounts.add(tempDebAcc);
                            //System.out.println("\nDebit account successfully created\n");

                            ((StandardClient) clients.get(i)).addAccount(tempDebAcc);

                            //todo escribir cuenta en fichero accounts.dat

                            path="src/proyectoterraques/files/accounts.dat";

                            account_data=accountNumber+","+tempDebAcc.amount+",null,null,"+dni_selected;

                            file.write(path,account_data);


                            return tempDebAcc;

                        }
                        else {

                            System.out.println("You can't add another debit account to the client\n");
                            return null;

                        }


                    } else if (clients.get(i) instanceof ShareholderClient) {

                        DebitAccount tempDebAcc = new DebitAccount(accountNumber, dni_selected);

                        tempDebAcc.dni=dni_selected;

                        //todo guardamos accountNumber en el archivo numberOfAccounts.dat

                        path="src/proyectoterraques/files/numberOfAccounts.dat";

                        file.rewrite(path,accountTenNumbers);

                        accounts.add(tempDebAcc);
                        //System.out.println("\nDebit account successfully created\n");

                        ((ShareholderClient) clients.get(i)).addAccount(tempDebAcc);

                        //todo escribir cuenta en fichero accounts.dat

                        path="src/proyectoterraques/files/accounts.dat";

                        account_data=accountNumber+","+tempDebAcc.amount+",null,null,"+dni_selected;

                        file.write(path,account_data);


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
                            CreditAccount tempCredAcc = new CreditAccount(accountNumber,dni_selected);

                            tempCredAcc.dni=dni_selected;

                            //todo guardamos accountNumber en el archivo numberOfAccounts.dat

                            path="src/proyectoterraques/files/numberOfAccounts.dat";

                            file.rewrite(path,accountTenNumbers);

                            accounts.add(tempCredAcc);
                            //System.out.println("\nCredit account successfully created\n");
                            ((ShareholderClient) clients.get(i)).addAccount(tempCredAcc);

                            //todo escribir cuenta en fichero accounts.dat

                            path="src/proyectoterraques/files/accounts.dat";

                            account_data=accountNumber+","+tempCredAcc.amount+","+tempCredAcc.debt+","+tempCredAcc.interest+","+dni_selected;

                            file.write(path,account_data);


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

    public void removeClient() throws IOException {

        String dni;
        boolean found=false;

        String dnix;
        String namex;
        String surnamex;
        String addressx;
        String phone_numberx;

        String accountNumberx;
        String ammountx;
        String debtx;
        String interestx;
        String dniz;

        System.out.print("Enter Client DNI: ");
        dni = scText.nextLine();
        for (int i=0; i<clients.size();i++){
            if (dni.equalsIgnoreCase(clients.get(i).getDni())){
                found=true;

                //todo borrar cuentas asociadas al cliente en el array de cuentas

                //principio
                if(clients.get(i) instanceof StandardClient){
                    for(int j=0;j<accounts.size();j++){
                        if(accounts.get(j).accountNumber.equalsIgnoreCase(((StandardClient) clients.get(i)).debit_Account.accountNumber)){
                            accounts.remove(j);
                            //todo borrar la cuenta del fichero accounts.dat

                            path="src/proyectoterraques/files/accounts.dat";
                            file.rewrite(path,"");


                            for(int k=0;k<accounts.size();k++){
                                if(accounts.get(k) instanceof DebitAccount){
                                    accountNumberx=((DebitAccount)accounts.get(k)).accountNumber;
                                    ammountx=Double.toString(((DebitAccount)accounts.get(k)).amount);
                                    dniz=((DebitAccount)accounts.get(k)).dni;
                                    account_data=accountNumberx+","+ammountx+",null,null,"+dniz;
                                    file.write(path,account_data);
                                }
                                else if(accounts.get(k) instanceof CreditAccount){
                                    accountNumberx=((CreditAccount) accounts.get(k)).accountNumber;
                                    ammountx=Double.toString(((CreditAccount)accounts.get(k)).amount);
                                    debtx=Double.toString(((CreditAccount)accounts.get(k)).debt);
                                    interestx=Double.toString(((CreditAccount)accounts.get(k)).interest);
                                    dniz=((CreditAccount)accounts.get(k)).dni;
                                    account_data=accountNumberx+","+ammountx+","+debtx+","+interestx+","+dniz;
                                    file.write(path,account_data);
                                }
                            }

                            file.clear();
                        }
                    }
                }
                else if (clients.get(i) instanceof ShareholderClient){
                    for(int j=0;j<accounts.size();j++){
                        if(((ShareholderClient) clients.get(i)).credit_Account!=null){
                            if(accounts.get(j).accountNumber.equalsIgnoreCase(((ShareholderClient) clients.get(i)).credit_Account.accountNumber)){
                                accounts.remove(j);
                                //todo borrar la cuenta del fichero accounts.dat

                                path="src/proyectoterraques/files/accounts.dat";
                                file.rewrite(path,"");


                                for(int k=0;k<accounts.size();k++){
                                    if(accounts.get(k) instanceof DebitAccount){
                                        accountNumberx=((DebitAccount)accounts.get(k)).accountNumber;
                                        ammountx=Double.toString(((DebitAccount)accounts.get(k)).amount);
                                        dniz=((DebitAccount)accounts.get(k)).dni;
                                        account_data=accountNumberx+","+ammountx+",null,null,"+dniz;
                                        file.write(path,account_data);
                                    }
                                    else if(accounts.get(k) instanceof CreditAccount){
                                        accountNumberx=((CreditAccount) accounts.get(k)).accountNumber;
                                        ammountx=Double.toString(((CreditAccount)accounts.get(k)).amount);
                                        debtx=Double.toString(((CreditAccount)accounts.get(k)).debt);
                                        interestx=Double.toString(((CreditAccount)accounts.get(k)).interest);
                                        dniz=((CreditAccount)accounts.get(k)).dni;
                                        account_data=accountNumberx+","+ammountx+","+debtx+","+interestx+","+dniz;
                                        file.write(path,account_data);
                                    }
                                }

                                file.clear();
                            }
                        }
                        //else{
                         //   System.out.println("No credit account vinculated to the client\n");
                        //}
                        if(((ShareholderClient) clients.get(i)).debitAccounts.size()>0){
                            for(int k=0;k<((ShareholderClient) clients.get(i)).debitAccounts.size();k++){
                                if(accounts.get(j).accountNumber.equalsIgnoreCase(((ShareholderClient) clients.get(i)).debitAccounts.get(k).accountNumber)){
                                    accounts.remove(j);
                                }
                            }
                        }
                        else{
                            System.out.println("No debit accounts vinculated to the client\n");
                        }
                        //todo borrar si esta en las cuentas de debito

                    }
                }

                //fin

                clients.remove(i);

                System.out.println("Client successfully removed\n");

                //todo borrar el cliente del fichero clients.dat

                path="src/proyectoterraques/files/clients.dat";
                file.rewrite(path,"");


                for(int j=0;j<clients.size();j++){
                    if(clients.get(j) instanceof StandardClient){

                        dnix=((StandardClient)clients.get(j)).dni;
                        namex=((StandardClient)clients.get(j)).name;
                        surnamex=((StandardClient)clients.get(j)).surname;
                        addressx=((StandardClient)clients.get(j)).address;
                        phone_numberx=((StandardClient)clients.get(j)).phoneNumber;
                        client_data=dnix+","+namex+","+surnamex+","+addressx+","+phone_numberx+",standard";

                        file.write(path,client_data);
                    }
                    else if(clients.get(j) instanceof ShareholderClient){

                        dnix=((ShareholderClient)clients.get(j)).dni;
                        namex=((ShareholderClient)clients.get(j)).name;
                        surnamex=((ShareholderClient)clients.get(j)).surname;
                        addressx=((ShareholderClient)clients.get(j)).address;
                        phone_numberx=((ShareholderClient)clients.get(j)).phoneNumber;
                        client_data=dnix+","+namex+","+surnamex+","+addressx+","+phone_numberx+",shareholder";

                        file.write(path,client_data);
                    }
                }

                file.clear();

            }
        }
        if (!found){
            System.out.println("Client not found\n");
        }

    }

    public void removeAccount() throws IOException {

        String accountNumber;
        boolean found=false;

        String accountNumberx;
        String ammountx;
        String debtx;
        String interestx;
        String dnix;

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
                            System.out.println("No debit account associated to the client\n");
                        }

                    }
                    else if(clients.get(j) instanceof ShareholderClient){
                        if(((ShareholderClient)clients.get(j)).credit_Account!=null){
                            if( ((ShareholderClient)clients.get(j)).credit_Account.accountNumber.equalsIgnoreCase(accountNumber) ){
                                ((ShareholderClient)clients.get(j)).credit_Account=null;
                            }
                        }
                        else{
                            System.out.println("No credit account associated to the client\n");
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
                            System.out.println("No debit accounts associated to the client\n");
                        }

                    }
                }

                System.out.println("Account successfully removed\n");

                //todo borrar la cuenta del fichero accounts.dat

                path="src/proyectoterraques/files/accounts.dat";
                file.rewrite(path,"");


                for(int j=0;j<accounts.size();j++){
                    if(accounts.get(j) instanceof DebitAccount){
                        accountNumberx=((DebitAccount)accounts.get(j)).accountNumber;
                        ammountx=Double.toString(((DebitAccount)accounts.get(j)).amount);
                        dnix=((DebitAccount)accounts.get(j)).dni;
                        account_data=accountNumberx+","+ammountx+",null,null,"+dnix;
                        file.write(path,account_data);
                    }
                    else if(accounts.get(j) instanceof CreditAccount){
                        accountNumberx=((CreditAccount) accounts.get(j)).accountNumber;
                        ammountx=Double.toString(((CreditAccount)accounts.get(j)).amount);
                        debtx=Double.toString(((CreditAccount)accounts.get(j)).debt);
                        interestx=Double.toString(((CreditAccount)accounts.get(j)).interest);
                        dnix=((CreditAccount)accounts.get(j)).dni;
                        account_data=accountNumberx+","+ammountx+","+debtx+","+interestx+","+dnix;
                        file.write(path,account_data);
                    }
                }

                file.clear();

            }
        }
        if (!found){
            System.out.println("Account not found\n");
        }

    }

    public void showClient(){

        String dni;
        boolean found=false;

        System.out.print("Enter Client DNI: ");
        dni = scText.nextLine();

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
            System.out.println("Client not found\n");
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
                System.out.println("Account not found\n");
        }

    }

    public void loadData(){

        String path2;

        //todo cargar accounts.dat al arraylist account

        System.out.println("\nLoading accounts...");

        int account_num=0;
        int client_num=0;

        path="src/proyectoterraques/files/accounts.dat";

        for (String currentAccount: file.loadFileContent(path)) {

            String[] cell;
            cell = currentAccount.split(",");

            String accountNumber = cell[0];
            String amount = cell[1];
            String debt = cell[2];
            String interest = cell[3];
            String dni = cell[4];

            if(interest.equalsIgnoreCase("null")){
                DebitAccount da = new DebitAccount(accountNumber, dni);
                da.amount=Double.parseDouble(amount);
                accounts.add(da);
                account_num++;
            }
            else{
                CreditAccount ca = new CreditAccount(accountNumber,dni);
                ca.amount=Double.parseDouble(amount);
                ca.debt=Double.parseDouble(debt);
                ca.interest=Double.parseDouble(interest);
                accounts.add(ca);
                account_num++;
            }
        }

        System.out.println(account_num + " accounts loaded");
        file.clear();



        //todo cargar clients.dat al arraylist clients

        System.out.println("\nLoading clients...");

        path="src/proyectoterraques/files/clients.dat";

        file.clear();

        for (String currentClient: file.loadFileContent(path)) {

            String[] cell;
            cell = currentClient.split(",");

            String dni = cell[0];
            String name = cell[1];
            String surname = cell[2];
            String address = cell[3];
            String phoneNumber = cell[4];
            String type = cell[5];


            if(type.equalsIgnoreCase("standard")){


                StandardClient stc = new StandardClient(dni,name,surname,address,phoneNumber);

                //todo cargar cuenta de debito del cliente

                path2="src/proyectoterraques/files/accounts.dat";

                file2.clear();

                for (String currentAccount: file2.loadFileContent(path2)) {

                    String[] cell2;
                    cell2 = currentAccount.split(",");

                    String accountNumberx = cell2[0];
                    String amountx = cell2[1];
                    String debtx = cell2[2];
                    String interestx = cell2[3];
                    String dnix = cell2[4];


                    if(dni.equalsIgnoreCase(dnix)){

                        DebitAccount da = new DebitAccount(accountNumberx, dnix);
                        da.amount=Double.parseDouble(amountx);
                        stc.addAccount(da);

                        clients.add(stc);
                    }
                }



            }
            else if(type.equalsIgnoreCase("shareholder")){

                ShareholderClient shc = new ShareholderClient(dni,name,surname,address,phoneNumber);

                //todo cargar cuentas de debito del cliente

                path2="src/proyectoterraques/files/accounts.dat";

                file2.clear();

                for (String currentAccount: file2.loadFileContent(path2)) {

                    String[] cell2;
                    cell2 = currentAccount.split(",");

                    String accountNumberx = cell2[0];
                    String amountx = cell2[1];
                    String debtx = cell2[2];
                    String interestx = cell2[3];
                    String dnix = cell2[4];


                    if(dni.equalsIgnoreCase(dnix)){

                        if(interestx.equalsIgnoreCase("null")){

                            DebitAccount da = new DebitAccount(accountNumberx, dnix);
                            da.amount=Double.parseDouble(amountx);
                            shc.addAccount(da);

                        }else{
                            CreditAccount ca = new CreditAccount(accountNumberx,dnix);
                            ca.amount=Double.parseDouble(amountx);
                            ca.debt=Double.parseDouble(debtx);
                            ca.interest=Double.parseDouble(interestx);
                            shc.addAccount(ca);
                        }

                        //clients.add(shc);
                    }
                }

                clients.add(shc);

            }

            client_num++;

        }

        System.out.println(client_num + " clients loaded");
        file.clear();
        file2.clear();

    }

   public void depositMoney(){

        String accountNumber;
        boolean found=false;

        String accountNumberx;
        String ammountx;
        String debtx;
        String interestx;
        String dnix;

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

                                //todo depositar dinero en arraylist de cuentas
                                ((CreditAccount) accounts.get(i)).deposit(amount);

                                //todo depositar dinero en arraylist de clientes
                                for(int j=0;j<clients.size();j++ ){

                                    if(clients.get(j) instanceof ShareholderClient){
                                        if(((ShareholderClient) clients.get(j)).credit_Account.accountNumber.equalsIgnoreCase(accountNumber)){
                                            ((ShareholderClient) clients.get(j)).credit_Account.deposit(amount);
                                            //dnix=((ShareholderClient) clients.get(j)).dni;
                                        }
                                    }
                                }

                                //todo depositar dinero en accounts.dat

                                path="src/proyectoterraques/files/accounts.dat";
                                file.rewrite(path,"");


                                for(int j=0;j<accounts.size();j++){
                                    if(accounts.get(j) instanceof DebitAccount){
                                        accountNumberx=((DebitAccount)accounts.get(j)).accountNumber;
                                        ammountx=Double.toString(((DebitAccount)accounts.get(j)).amount);
                                        dnix=((DebitAccount)accounts.get(j)).dni;
                                        account_data=accountNumberx+","+ammountx+",null,null,"+dnix;
                                        file.write(path,account_data);
                                    }
                                    else if(accounts.get(j) instanceof CreditAccount){
                                        accountNumberx=((CreditAccount) accounts.get(j)).accountNumber;
                                        ammountx=Double.toString(((CreditAccount)accounts.get(j)).amount);
                                        debtx=Double.toString(((CreditAccount)accounts.get(j)).debt);
                                        interestx=Double.toString(((CreditAccount)accounts.get(j)).interest);
                                        dnix=((CreditAccount)accounts.get(j)).dni;
                                        account_data=accountNumberx+","+ammountx+","+debtx+","+interestx+","+dnix;
                                        file.write(path,account_data);
                                    }
                                }




                            } else if (accounts.get(i) instanceof DebitAccount){

                                //todo depositar dinero en arraylist de cuentas
                                ((DebitAccount) accounts.get(i)).deposit(amount);

                                //todo depositar dinero en arraylist de clientes
                                for(int j=0;j<clients.size();j++ ){

                                    if(clients.get(j) instanceof StandardClient){
                                        if(((StandardClient) clients.get(j)).debit_Account.accountNumber.equalsIgnoreCase(accountNumber)){
                                            ((StandardClient) clients.get(j)).debit_Account.deposit(amount);

                                        }
                                    }
                                    else if(clients.get(j) instanceof ShareholderClient) {

                                        for (int k = 0; k<((ShareholderClient) clients.get(j)).debitAccounts.size() ; k++){
                                            if (((ShareholderClient) clients.get(j)).debitAccounts.get(k).accountNumber.equalsIgnoreCase(accountNumber)) {
                                                //((ShareholderClient) clients.get(j)).debitAccounts.get(k).deposit(amount);

                                            }
                                        }
                                    }
                                }

                                //todo depositar dinero en accounts.dat
                                path="src/proyectoterraques/files/accounts.dat";
                                file.rewrite(path,"");

                                for(int j=0;j<accounts.size();j++){
                                    if(accounts.get(j) instanceof DebitAccount){
                                        accountNumberx=((DebitAccount)accounts.get(j)).accountNumber;
                                        ammountx=Double.toString(((DebitAccount)accounts.get(j)).amount);
                                        dnix=((DebitAccount)accounts.get(j)).dni;
                                        account_data=accountNumberx+","+ammountx+",null,null,"+dnix;
                                        file.write(path,account_data);
                                    }
                                    else if(accounts.get(j) instanceof CreditAccount){
                                        accountNumberx=((CreditAccount) accounts.get(j)).accountNumber;
                                        ammountx=Double.toString(((CreditAccount)accounts.get(j)).amount);
                                        debtx=Double.toString(((CreditAccount)accounts.get(j)).debt);
                                        interestx=Double.toString(((CreditAccount)accounts.get(j)).interest);
                                        dnix=((CreditAccount)accounts.get(j)).dni;
                                        account_data=accountNumberx+","+ammountx+","+debtx+","+interestx+","+dnix;
                                        file.write(path,account_data);
                                    }
                                }

                            }

                        }catch (InvalidCharacterException e){
                            System.out.println("Error: "+e);
                        }
                    }catch(Exception e){
                        System.out.println("Only numeric characters allowed\n");
                    }

                }
            }
        }
        if (!found){
            System.out.println("Account not found\n");
        }




    }

    public void withDrawMoney(){

        String accountNumber;
        boolean found=false;

        String accountNumberx;
        String ammountx;
        String debtx;
        String interestx;
        String dnix;

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

                                //todo retirar dinero en arraylist de cuentas
                                ((CreditAccount) accounts.get(i)).withdraw(amount);

                                //todo retirar dinero en arraylist de clientes
                                for(int j=0;j<clients.size();j++ ){
                                    if(clients.get(j) instanceof ShareholderClient){
                                        if(((ShareholderClient) clients.get(j)).credit_Account.accountNumber.equalsIgnoreCase(accountNumber)){
                                            ((ShareholderClient) clients.get(j)).credit_Account.withdraw(amount);
                                            //dnix=((ShareholderClient) clients.get(j)).dni;
                                        }
                                    }
                                }

                                //todo retirar dinero en accounts.dat
                                path="src/proyectoterraques/files/accounts.dat";
                                file.rewrite(path,"");


                                for(int j=0;j<accounts.size();j++){
                                    if(accounts.get(j) instanceof DebitAccount){
                                        accountNumberx=((DebitAccount)accounts.get(j)).accountNumber;
                                        ammountx=Double.toString(((DebitAccount)accounts.get(j)).amount);
                                        dnix=((DebitAccount)accounts.get(j)).dni;
                                        account_data=accountNumberx+","+ammountx+",null,null,"+dnix;
                                        file.write(path,account_data);
                                    }
                                    else if(accounts.get(j) instanceof CreditAccount){
                                        accountNumberx=((CreditAccount) accounts.get(j)).accountNumber;
                                        ammountx=Double.toString(((CreditAccount)accounts.get(j)).amount);
                                        debtx=Double.toString(((CreditAccount)accounts.get(j)).debt);
                                        interestx=Double.toString(((CreditAccount)accounts.get(j)).interest);
                                        dnix=((CreditAccount)accounts.get(j)).dni;
                                        account_data=accountNumberx+","+ammountx+","+debtx+","+interestx+","+dnix;
                                        file.write(path,account_data);
                                    }
                                }


                            } else if (accounts.get(i) instanceof DebitAccount){

                                //todo retirar dinero en arraylist de cuentas
                                ((DebitAccount) accounts.get(i)).withdraw(amount);

                                //todo retirar dinero en arraylist de clientes
                                for(int j=0;j<clients.size();j++ ){
                                    if(clients.get(j) instanceof StandardClient){
                                        if(((StandardClient) clients.get(j)).debit_Account.accountNumber.equalsIgnoreCase(accountNumber)){
                                            ((StandardClient) clients.get(j)).debit_Account.withdraw(amount);
                                            //dnix=((StandardClient) clients.get(j)).dni;
                                        }
                                    }
                                    else if(clients.get(j) instanceof ShareholderClient) {
                                        for (int k = 0; k<((ShareholderClient) clients.get(j)).debitAccounts.size() ; k++){
                                            if (((ShareholderClient) clients.get(j)).debitAccounts.get(k).accountNumber.equalsIgnoreCase(accountNumber)) {
                                                ((ShareholderClient) clients.get(j)).debitAccounts.get(k).withdraw(amount);
                                                //dnix=((ShareholderClient) clients.get(j)).dni;
                                            }
                                        }
                                    }
                                }

                                //todo retirar dinero en accounts.dat
                                path="src/proyectoterraques/files/accounts.dat";
                                file.rewrite(path,"");


                                for(int j=0;j<accounts.size();j++){
                                    if(accounts.get(j) instanceof DebitAccount){
                                        accountNumberx=((DebitAccount)accounts.get(j)).accountNumber;
                                        ammountx=Double.toString(((DebitAccount)accounts.get(j)).amount);
                                        dnix=((DebitAccount)accounts.get(j)).dni;
                                        account_data=accountNumberx+","+ammountx+",null,null,"+dnix;
                                        file.write(path,account_data);
                                    }
                                    else if(accounts.get(j) instanceof CreditAccount){
                                        accountNumberx=((CreditAccount) accounts.get(j)).accountNumber;
                                        ammountx=Double.toString(((CreditAccount)accounts.get(j)).amount);
                                        debtx=Double.toString(((CreditAccount)accounts.get(j)).debt);
                                        interestx=Double.toString(((CreditAccount)accounts.get(j)).interest);
                                        dnix=((CreditAccount)accounts.get(j)).dni;
                                        account_data=accountNumberx+","+ammountx+","+debtx+","+interestx+","+dnix;
                                        file.write(path,account_data);
                                    }
                                }
                            }

                        }catch (InvalidCharacterException e){
                            System.out.println("Error: "+e);
                        }
                    }catch(Exception e){
                        System.out.println("Only numeric characters allowed\n");
                    }

                }
            }
        }
        if (!found){
            System.out.println("Account not found\n");
        }

    }




}
