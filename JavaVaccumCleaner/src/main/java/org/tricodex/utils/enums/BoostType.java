package org.tricodex.utils.enums;

public enum BoostType {
    BATTERY_LEVEL("Battery Level"),
    BATTERY_MAX("Battery Max"),
    VACUUM_CAPACITY("Vacuum Capacity"),
    RECHARGE_MAX("Recharge Max"),
    EMPTY_MAX("Empty Max");

    private final String displayName;

    BoostType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
