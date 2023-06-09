package org.tricodex.view.services;

import org.tricodex.model.Vacuum;

public class StatusService {
    private final Vacuum vacuum;

    public StatusService(Vacuum vacuum) {
        this.vacuum = vacuum;
    }

    public String getBag() {
        return ("Bag: " + vacuum.getBagFill() + "/" + vacuum.getBagCapacity());
    }

    public String getBattery() {
        return ("Battery: " + String.format("%.2f", vacuum.getBatteryFill()) + "/" + vacuum.getBatteryCapacity());
    }

    public String getVaccumRecharge() {
        return ("Recharge: " + vacuum.getNumRecharges() + "/" + vacuum.getMAX_RECHARGES());
    }

    public String getVaccumEmpty() {
        return ("Empty: " + vacuum.getNumEmpties() + "/" + vacuum.getMAX_EMPTIES());
    }

    public String getPowerUp(String boostTypeReceived) {
        return ("PowerUp: " + boostTypeReceived);
    }
}
