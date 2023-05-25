package proyectoterraques.source;

public abstract class Client {

    String dni;
    String name;
    String surname;
    String address;
    String phoneNumber;

    public Client(String dni, String name, String surname, String address, String phoneNumber) {
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getDni() {
        return dni;
    }

    public String getFullName(){
        String fullName;
        fullName = name+" "+surname;
        return fullName;
    }

    public String getFullData(){
        String fullData;
        fullData = dni+" - "+getFullName()+" - "+address+" - "+phoneNumber;
        return fullData;
    }
}
