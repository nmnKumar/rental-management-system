package application;

import java.util.ArrayList;
import java.util.List;

public class RentalUnitService {
    private List<RentalUnit> rentalUnits;
    private List<RentalUnit> vacantUnits;
    private List<RentalUnit> rentedUnits;
    private int id;

    public RentalUnitService() {
        rentalUnits = new ArrayList<>();
        vacantUnits = new ArrayList<>();
        rentedUnits = new ArrayList<>();
        id = 1;
    }

    public String addRentalUnit(RentalUnit rentalUnit) {
        for (RentalUnit unit : rentalUnits) {
            if (unit.getId() == rentalUnit.getId()) {
                return "Rental unit already exists.";
            }
        }
        rentalUnit.setId(id);
        rentalUnits.add(rentalUnit);
        vacantUnits.add(rentalUnit);
        id++;
        return "Rental unit added successfully.";
    }

    public String removeRentalUnit(int id) {
        for (RentalUnit rentalUnit : rentalUnits) {
            if (rentalUnit.getId() == id) {
                if (rentalUnit.isAvailable()) {
                    vacantUnits.remove(rentalUnit);
                } else {
                    rentedUnits.remove(rentalUnit);
                }
                rentalUnits.remove(rentalUnit);
                return "Rental unit removed successfully.";
            }
        }
        return "Rental unit not found.";
    }

    public List<RentalUnit> getAllRentalUnits() {
        return rentalUnits;
    }

    public List<RentalUnit> getVacantUnits() {
        return vacantUnits;
    }

    public RentalUnit getRentalUnit(int id) {
        for (RentalUnit rentalUnit : rentalUnits) {
            if (rentalUnit.getId() == id) {
                return rentalUnit;
            }
        }
        return null;
    }

    public List<RentalUnit> getRentedUnits() {
        return rentedUnits;
    }

    public void rentUnit(RentalUnit rentalUnit) {
        if (rentalUnit.isAvailable()) {
            rentalUnit.setAvailable(false);
            vacantUnits.remove(rentalUnit);
            rentedUnits.add(rentalUnit);
        }
    }

    public void releaseUnit(RentalUnit rentalUnit) {
        if (!rentalUnit.isAvailable()) {
            rentalUnit.setAvailable(true);
            rentedUnits.remove(rentalUnit);
            vacantUnits.add(rentalUnit);
        }
    }
}
