package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import application.RentalUnit;
import application.RentalUnitService;

class RentalUnitServiceTest {

    @Test
    void testAddRentalUnit() {
        RentalUnitService rentalUnitService = new RentalUnitService();
        RentalUnit rentalUnit = new RentalUnit(1, "DLF Phase 3", 12000.0, 2, 1) {
            @Override
            public String getType() {
                return "House";
            }
        };

        String result = rentalUnitService.addRentalUnit(rentalUnit);

        assertEquals("Rental unit added successfully.", result);
        assertEquals(1, rentalUnitService.getAllRentalUnits().size());
    }

    @Test
    void testAddDuplicateRentalUnit() {
        RentalUnitService rentalUnitService = new RentalUnitService();
        RentalUnit rentalUnit1 = new RentalUnit(1, "DLF Phase 3", 12000.0, 2, 1) {
            @Override
            public String getType() {
                return "House";
            }
        };
        RentalUnit rentalUnit2 = new RentalUnit(1, "DLF Phase 3", 15000.0, 3, 2) {
            @Override
            public String getType() {
                return "Apartment";
            }
        };

        String result1 = rentalUnitService.addRentalUnit(rentalUnit1);
        String result2 = rentalUnitService.addRentalUnit(rentalUnit2);

        assertEquals("Rental unit added successfully.", result1);
        assertEquals("Rental unit already exists.", result2);
        assertEquals(1, rentalUnitService.getAllRentalUnits().size());
    }

    @Test
    void testRemoveRentalUnit() {
        RentalUnitService rentalUnitService = new RentalUnitService();
        RentalUnit rentalUnit = new RentalUnit(1, "DLF Phase 3", 12000.0, 2, 1) {
            @Override
            public String getType() {
                return "House";
            }
        };
        rentalUnitService.addRentalUnit(rentalUnit);

        String result = rentalUnitService.removeRentalUnit(1);

        assertEquals("Rental unit removed successfully.", result);
        assertEquals(0, rentalUnitService.getAllRentalUnits().size());
    }

    @Test
    void testRemoveNonExistentRentalUnit() {
        RentalUnitService rentalUnitService = new RentalUnitService();

        String result = rentalUnitService.removeRentalUnit(1);

        assertEquals("Rental unit not found.", result);
        assertEquals(0, rentalUnitService.getAllRentalUnits().size());
    }


    @Test
    void testGetAllRentalUnits() {
        RentalUnitService rentalUnitService = new RentalUnitService();
        RentalUnit rentalUnit1 = new RentalUnit(1, "DLF Phase 3", 12000.0, 2, 1) {
            @Override
            public String getType() {
                return "House";
            }
        };
        RentalUnit rentalUnit2 = new RentalUnit(2, "Sohna Road", 15000.0, 3, 2) {
            @Override
            public String getType() {
                return "Apartment";
            }
        };
        rentalUnitService.addRentalUnit(rentalUnit1);
        rentalUnitService.addRentalUnit(rentalUnit2);

        assertEquals(2, rentalUnitService.getAllRentalUnits().size());
    }



}