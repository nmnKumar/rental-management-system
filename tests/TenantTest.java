package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Tenant;

class TenantTest {

    private Tenant tenant;
    private LocalDate today;

    @BeforeEach
    void setUp() {
        today = LocalDate.now();
        tenant = new Tenant("John Doe", "555-1234", "johndoe@example.com", "123 Main St");
    }

    @Test
    void testConstructor() {
        assertEquals("John Doe", tenant.getName());
        assertEquals("555-1234", tenant.getPhone());
        assertEquals("johndoe@example.com", tenant.getEmail());
        assertEquals("123 Main St", tenant.getOccupation());
    }

    @Test
    void testSetters() {
        String newName = "Jane Smith";
        tenant.setName(newName);
        assertEquals(newName, tenant.getName());

        String newPhone = "555-5678";
        tenant.setPhone(newPhone);
        assertEquals(newPhone, tenant.getPhone());

        String newEmail = "janesmith@example.com";
        tenant.setEmail(newEmail);
        assertEquals(newEmail, tenant.getEmail());

        String newOccupation = "456 Oak St";
        tenant.setOccupation(newOccupation);
        assertEquals(newOccupation, tenant.getOccupation());
    }
}
