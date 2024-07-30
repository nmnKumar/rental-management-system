package presentation;

import application.*;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class RentalUnitMenu {
    private RentalUnitService rentalUnitService;
    private TenantService tenantService;
    private LeaseService leaseService;
    private Scanner scanner;

    public RentalUnitMenu() {
        rentalUnitService = new RentalUnitService();
        tenantService = new TenantService();
        leaseService = new LeaseService();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Rental Unit Management System ===");
            System.out.println("1. Add Property");
            System.out.println("2. Add Tenant");
            System.out.println("3. Rent a Unit");
            System.out.println("4. Display Properties");
            System.out.println("5. Display Tenants");
            System.out.println("6. Display Rented Units");
            System.out.println("7. Display Vacant Units");
            System.out.println("8. Display All Leases");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addRentalUnit();
                    break;
                case 2:
                    addTenant();
                    break;
                case 3:
                    rentUnit();
                    break;
                case 4:
                    displayProperties();
                    break;
                case 5:
                    displayTenants();
                    break;
                case 6:
                    displayRentedUnits();
                    break;
                case 7:
                    displayVacantUnits();
                    break;
                case 8:
                    displayAllLeases();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayAllLeases() {
        List<Lease> allLeases = leaseService.getLeases();
        for (Lease lease : allLeases) {
            System.out.println(lease.toString());
        }
    }

    private void displayRentedUnits() {
        List<RentalUnit> rentedUnits = rentalUnitService.getRentedUnits();

        if (rentedUnits.isEmpty()) {
            System.out.println("There are no rented units.");
        } else {
            System.out.println("Rented units:");
            for (RentalUnit rentalUnit : rentedUnits) {
                System.out.println(rentalUnit);
            }
        }
    }

    public void displayVacantUnits() {
        List<RentalUnit> vacantUnits = rentalUnitService.getVacantUnits();

        if (vacantUnits.isEmpty()) {
            System.out.println("There are no vacant rental units.");
        } else {
            System.out.println("Vacant Rental Units:");
            for (RentalUnit rentalUnit : vacantUnits) {
                System.out.println(rentalUnit.toString() + " [Available for rent]");
            }
        }
    }



    private void displayProperties() {
        List<RentalUnit> properties = rentalUnitService.getAllRentalUnits();
        for (RentalUnit property : properties) {
            System.out.println(property.toString());
        }
    }

    private void addRentalUnit() {
        System.out.println("Enter the type of rental unit (House, Apartment, or Condo):");
        String type = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the monthly rent:");
        double monthlyRent = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter the number of rooms:");
        int numberOfRooms = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter the number of bathrooms:");
        int numberOfBathrooms = Integer.parseInt(scanner.nextLine());

        RentalUnit rentalUnit;
        switch (type.toLowerCase()) {
            case "house":
                int newId = rentalUnitService.getAllRentalUnits().size() + 1;
                System.out.println("Does the house have yard? (yes/no):");
                boolean hasYard = scanner.nextLine().equalsIgnoreCase("yes");
                rentalUnit = new House(newId, address, monthlyRent, numberOfRooms, numberOfBathrooms, hasYard);
                break;
            case "apartment":
                System.out.println("Does the apartment have laundry? (yes/no):");
                boolean hasLaundry = scanner.nextLine().equalsIgnoreCase("yes");
                System.out.println("Does the apartment have parking? (yes/no):");
                boolean hasParking = scanner.nextLine().equalsIgnoreCase("yes");
                System.out.println("Does the apartment have an elevator? (yes/no):");
                boolean hasElevator = scanner.nextLine().equalsIgnoreCase("yes");
                rentalUnit = new Apartment(0, address, monthlyRent, numberOfRooms, numberOfBathrooms, hasLaundry, hasParking, hasElevator);
                break;
            case "condo":
                System.out.println("Enter the condo number:");
                int condoNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter the condo fee:");
                double condoFee = Double.parseDouble(scanner.nextLine());
                rentalUnit = new Condo(0, address, monthlyRent, numberOfRooms, numberOfBathrooms, condoFee);
                break;
            default:
                System.out.println("Invalid rental unit type.");
                return;
        }

        String result = rentalUnitService.addRentalUnit(rentalUnit);
        System.out.println(result);
    }

    private void addTenant() {
        System.out.println("\n=== Add a Tenant ===");

        // Get tenant information from user
        System.out.print("Enter the tenant's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the tenant's phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter the tenant's email address: ");
        String email = scanner.nextLine();

        System.out.print("Enter the tenant's occupation: ");
        String occupation = scanner.nextLine();


        // Add tenant to tenant service
        try {
            tenantService.addTenant(name, phone, email, occupation);
            System.out.println("Tenant added successfully!");
        } catch (Exception e) {
            System.out.println("Error adding tenant: " + e.getMessage());
        }

    }

    private void rentUnit() {
        System.out.println("\n=== Rent a Unit ===");

        // Display list of vacant units
        List<RentalUnit> vacantUnits = rentalUnitService.getVacantUnits();
        if (vacantUnits.isEmpty()) {
            System.out.println("No vacant units available for rent.");
            return;
        } else {
            System.out.println("Available Units:");
            for (RentalUnit rentalUnit : vacantUnits) {
                System.out.println(rentalUnit.toString() + " [Available for rent]");
            }
        }

        // Select a vacant unit to rent
        System.out.print("\nEnter the ID of the unit to rent: ");
        int unitId = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        RentalUnit rentalUnit = rentalUnitService.getRentalUnit(unitId);
        if (rentalUnit == null) {
            System.out.println("Unit not found.");
            return;
        }
        if (!rentalUnit.isAvailable()) {
            System.out.println("Unit is not available for rent.");
            return;
        }

        // Get lease details from user
        System.out.println("\nEnter lease details:");
        System.out.print("Start date (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        LocalDate startDate;
        try {
            startDate = LocalDate.parse(startDateStr);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
            return;
        }
        System.out.print("Duration (months): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Ask user if they want to rent to a new tenant or an existing tenant
        System.out.println("\nDo you want to rent to an existing tenant or a new tenant?");
        System.out.println("1. Existing tenant");
        System.out.println("2. New tenant");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        // Rent to existing tenant
        if (choice == 1) {
            // Display list of all tenants
            List<Tenant> tenants = tenantService.getAllTenants();
            if (tenants.isEmpty()) {
                System.out.println("No tenants found.");
                return;
            } else {
                System.out.println("Available Tenants:");
                for (Tenant tenant : tenants) {
                    System.out.println(tenant.toString());
                }
            }
            // Select a tenant to rent to
            System.out.print("\nEnter the name of the tenant to rent to: ");
            String tenantName = scanner.next();

            Tenant tenant = tenantService.getTenantByName(tenantName);

            scanner.nextLine(); // Consume newline left-over
            if (tenant == null) {
                System.out.println("Tenant not found.");
                return;
            }

            // Create new lease
            Lease lease = new Lease(0, rentalUnit, startDate, startDate.plusMonths(duration), rentalUnit.getMonthlyRent());
            try {
                leaseService.addLease(lease);
                rentalUnit.setIsAvailable(false); // Update rental unit availability
                rentalUnitService.rentUnit(rentalUnit); // Add rental unit to rented units list
                rentalUnitService.getRentedUnits().add(rentalUnit); // Add rental unit to rented units list
                vacantUnits.remove(rentalUnit); // Remove rental unit from vacant units list
                System.out.println("Rented successfully to existing tenant.");
            } catch (Exception e) {
                System.out.println("Error while renting on lease: " + e.getMessage());
            }
        }

        // Rent to new tenant
        else if (choice == 2) {
            System.out.println("\n=== Rent to New Tenant ===");
            // Get tenant details from user
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Occupation: ");
            String occupation = scanner.nextLine();
            // Create new lease
            Lease lease = new Lease(0, rentalUnit, startDate, startDate.plusMonths(duration), rentalUnit.getMonthlyRent());
            try {
                leaseService.addLease(lease);
                rentalUnit.setIsAvailable(false); // Update rental unit availability
                rentalUnitService.rentUnit(rentalUnit); // Add rental unit to rented units list
                rentalUnitService.getRentedUnits().add(rentalUnit); // Add rental unit to rented units list
                vacantUnits.remove(rentalUnit); // Remove rental unit from vacant units list
                tenantService.addTenant(name,phone, email, occupation);
                System.out.println("Rented successfully to new tenant.");
            } catch (Exception e) {
                System.out.println("Error while renting on lease: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid choice.");
            return;
        }
}

        public void displayTenants() {
        List<Tenant> tenants = tenantService.getAllTenants();
        System.out.println("Tenant List:");
        for (Tenant tenant : tenants) {
            System.out.println(tenant.toString());
        }
    }





}
