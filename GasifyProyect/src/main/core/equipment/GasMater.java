package main.core.equipment;

public class GasMater {

    private String idGasMeter;
    private String brand;
    private String ref;
    private String ean13;
    private String serie;
    private String nameModel;
    private int readInstallationDay;
    private String plcId;

    public GasMater(String idGasMater, String brand, String ref, String ean13, String serie, int readInstallationDay,String plcId ) {
        this.idGasMeter = idGasMater;
        this.brand=brand;
        this.ref=ref;
        this.ean13=ean13;
        this.serie=serie;
        this.readInstallationDay = readInstallationDay;
        this.plcId = plcId;

    }

    public GasMater() {

    }

    public String getPlcId(){return this.plcId;}

    public void setPlcId(String plcId){this.plcId=plcId;}

    public String getIdGasMater() {
        return idGasMeter;
    }

    public void setIdGasMater(String idGasMater) {
        this.idGasMeter = idGasMater;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public int getReadInstallationDay() {
        return readInstallationDay;
    }

    public void setReadInstallationDay(int readInstallationDay) {
        this.readInstallationDay = readInstallationDay;
    }


    public String toStringGasMater() {
        return "GasMater{" +
                "idGasMater='" + idGasMeter + '\'' +
                ", brand='" + brand + '\'' +
                ", ref='" + ref + '\'' +
                ", ean13='" + ean13 + '\'' +
                ", serie='" + serie + '\'' +

                ", readInstallationDay=" + readInstallationDay +
                '}';
    }
}
