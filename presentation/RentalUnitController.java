package presentation;

import java.util.List;

import application.RentalUnit;
import application.RentalUnitService;

public class RentalUnitController {
    private RentalUnitService service;

    public RentalUnitController(RentalUnitService service) {
        this.service = service;
    }

    public String addRentalUnit(RentalUnit rentalUnit) {
        return service.addRentalUnit(rentalUnit);
    }



    public List<RentalUnit> getAllRentalUnits() {
        return service.getAllRentalUnits();
    }
}
