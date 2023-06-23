package models;

public class MaintenanceModel {
    private java.util.List<MachineModel> machines;

    public MaintenanceModel( java.util.List<MachineModel> machines ){
        this.machines = machines;
    }

    public java.util.List<MachineModel> getMachines(){
        return machines;
    }
}
