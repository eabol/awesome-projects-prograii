package main.core.equipment;

public class DataSim {

    private String idDataSim;
    private String numberDataSim;
    private String serviceCompany;

    public DataSim(String idDataSim, String numberDataSim, String serviceCompany) {
        this.idDataSim = idDataSim;
        this.numberDataSim = numberDataSim;
        this.serviceCompany = serviceCompany;
    }

    public DataSim() {

    }

    public String getIdDataSim() {
        return idDataSim;
    }

    public void setIdDataSim(String idDataSim) {
        this.idDataSim = idDataSim;
    }

    public String getNumberDataSim() {
        return numberDataSim;
    }

    public void setNumberDataSim(String numberDataSim) {
        this.numberDataSim = numberDataSim;
    }

    public String getServiceCompany() {
        return serviceCompany;
    }

    public void setServiceCompany(String serviceCompany) {
        this.serviceCompany = serviceCompany;
    }


    public String toStringDataSim() {
        return "DataSim{" +
                "idDataSim='" + idDataSim + '\'' +
                ", numberDataSim='" + numberDataSim + '\'' +
                ", serviceCompany='" + serviceCompany + '\'' +
                '}';
    }
}
