package application;

import java.util.ArrayList;
import java.util.List;

public class RentalUnitManager {
    private List<RentalUnit> rentalUnits;

    public RentalUnitManager() {
        rentalUnits = new ArrayList<>();
    }

    public String addRentalUnit(RentalUnit rentalUnit) {
        for (RentalUnit unit : rentalUnits) {
            if (unit.getAddress().equalsIgnoreCase(rentalUnit.getAddress())) {
                return "Error: Rental unit already exists at this address.";
            }
        }
        rentalUnits.add(rentalUnit);
        return "Rental unit added successfully.";
    }

    public String removeRentalUnit(String address) {
        for (int i = 0; i < rentalUnits.size(); i++) {
            RentalUnit rentalUnit = rentalUnits.get(i);
            if (rentalUnit.getAddress().equalsIgnoreCase(address)) {
                rentalUnit.setAvailable(false);
                rentalUnits.set(i, rentalUnit);
                return "Rental unit removed successfully.";
            }
        }
        return "Error: Rental unit not found at this address.";
    }

    public List<RentalUnit> getAllRentalUnits() {
        List<RentalUnit> availableUnits = new ArrayList<>();
        for (RentalUnit rentalUnit : rentalUnits) {
            if (rentalUnit.isAvailable()) {
                availableUnits.add(rentalUnit);
            }
        }
        return availableUnits;
    }

    public List<RentalUnit> getRentalUnitsByType(String type) {
        List<RentalUnit> unitsByType = new ArrayList<>();
        for (RentalUnit rentalUnit : rentalUnits) {
            if (rentalUnit.getType().equalsIgnoreCase(type) && rentalUnit.isAvailable()) {
                unitsByType.add(rentalUnit);
            }
        }
        return unitsByType;
    }
}
