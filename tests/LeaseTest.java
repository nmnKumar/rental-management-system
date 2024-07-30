package tests;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import application.Lease;
import application.RentalUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeaseTest {

    private RentalUnit rentalUnit;
    private Lease lease;
    private LocalDate today;

    @BeforeEach
    void setUp() {
        rentalUnit = new RentalUnit(1, "DLF Phase 3", 12000.0, 2, 1) {
            @Override
            public String getType() {
                return "House";
            }
        };
        today = LocalDate.now();
        lease = new Lease(1, rentalUnit, today.minusDays(1), today.plusDays(30), 1000.0);
    }


    @Test
    void testConstructor() {
        assertEquals(1, lease.getId());
        assertEquals(rentalUnit, lease.getRentalUnit());
        assertEquals(today.minusDays(1), lease.getStartDate());
        assertEquals(today.plusDays(30), lease.getEndDate());
        assertEquals(1000.0, lease.getMonthlyRent());
        assertTrue(lease.isActive());
    }

    @Test
    void testSetters() {
        lease.setId(2);
        assertEquals(2, lease.getId());
        RentalUnit newUnit = new RentalUnit(1, "DLF Phase 3", 12000.0, 2, 1) {
            @Override
            public String getType() {
                return "Hello";
            }
        };
        lease.setRentalUnit(newUnit);
        assertEquals(newUnit, lease.getRentalUnit());

        LocalDate newStartDate = today.minusDays(10);
        lease.setStartDate(newStartDate);
        assertEquals(newStartDate, lease.getStartDate());

        LocalDate newEndDate = today.plusDays(60);
        lease.setEndDate(newEndDate);
        assertEquals(newEndDate, lease.getEndDate());

        double newMonthlyRent = 1500.0;
        lease.setMonthlyRent(newMonthlyRent);
        assertEquals(newMonthlyRent, lease.getMonthlyRent(), 0.001);

        lease.setActive(false);
        assertFalse(lease.isActive());
    }

    @Test
    void testSetActive() {
        assertTrue(lease.isActive());

        lease.setActive(false);
        assertFalse(lease.isActive());

        lease.setActive(true);
        assertTrue(lease.isActive());
    }
}
