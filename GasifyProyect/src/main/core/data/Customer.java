package main.core.data;

public class Customer {

    private String idCustomer;
    private String nameCustomer;
    private String numberPhone;
    private String address;
    private String plcId;
    private String simId;
    private String gasMaterID;


    public Customer(String idCustomer,String nameCustomer, String numberPhone, String address, String plcId, String simId, String gasMaterID) {
        this.idCustomer = idCustomer;
        this.nameCustomer=nameCustomer;
        this.numberPhone = numberPhone;
        this.address = address;
        this.plcId = plcId;
        this.simId = simId;
        this.gasMaterID = gasMaterID;
    }

    public Customer() {

    }

    public void setNameCustomer(String nameCustomer){

        this.nameCustomer= nameCustomer;
    }

    public String getNameCustomer(){

        return this.nameCustomer;
    }
    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;

    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlcId() {
        return plcId;
    }

    public void setPlcId(String plcId) {
        this.plcId = plcId;
    }

    public String getSimId() {
        return simId;
    }

    public void setSimId(String simId) {
        this.simId = simId;
    }

    public String getGasMaterID() {
        return gasMaterID;
    }

    public void setGasMaterID(String gasMaterID) {
        this.gasMaterID = gasMaterID;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}