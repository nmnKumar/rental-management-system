# Rental Management System
This is a rental management system built using Java.

## Project Overview
The rental management system allows property managers to manage rental units, leases, and tenants. The system provides a user-friendly interface for managing rental properties and their associated data. The main features of the system include:

* Add and remove rental units
* Add and end leases
* Add and remove tenants
* Display all rental units
* Display all tenants
* Display all rented units
* Display all vacant units

## Packages
The project is divided into the following packages:

### main
The main package contains the Main class, which is the entry point of the application. It creates an instance of the RentalUnitMenu class from the presentation package and calls its run method to start the application.

### application
The application package contains the RentalUnit and RentalUnitService classes. The RentalUnit class is a simple Java bean that represents a rental unit, and the RentalUnitService class provides methods for adding, updating, deleting, and retrieving rental units.

### data
The data package contains all information about data layer of 3-layer architecture and mocking data through objects

### presentation
The presentation package contains the RentalUnitMenu class, which provides a menu-driven user interface for the rental management system. It uses the RentalUnitService class to perform CRUD (create, read, update, delete) operations on rental units.

tests
The tests package contains unit tests for the RentalUnitService class. The tests cover various scenarios, such as adding rental units, updating rental units, deleting rental units, and handling duplicate rental units.

## UML Diagrams and High level Design Patterns :
```bash
+---------------------+          +---------------------------+          +-------------------------+
|      RentalUnit       |          |         LeaseService       |          |        Tenant           |
+---------------------+ |         +---------------------------+ |        +-------------------------+
|   - id: int           |          |  - leases: List<Lease>     |          |  - name: String          |
|   - address: String   |          |                            |          |  - phone: String         |
|   - rentalFee: double |          |  + addLease(lease: Lease)  |          |  - email: String         |
|   - available: boolean|          |  + getLeases(): List<Lease>|          |  - occupation: String    |
|                       |          |  + getActiveLeases(): List<Lease>|    |  + Tenant(name, phone, email, occupation)|
|                       |          |  + endLease(lease: Lease)  |          |  + toString(): String    |
|   + displayInfo(): void |        |                            |          |                          |
|                       |          |                            |          |                          |
+---------------------+          +--------------+------------+          +-------------------------+
                                       |         implements        |
                                       |                           |
                                       |                           |
                                       |                           |
                         +---------------------------+             |
                         |           Lease           |             |
                         +---------------------------+             |
                         |  - leaseNumber: int        |            |
                         |  - startDate: LocalDate    |            |
                         |  - endDate: LocalDate      |            |
                         |  - rentalUnit: RentalUnit  |            |
                         |  - tenant: Tenant          |            |
                         |  - active: boolean         |            |
                         |                           |             |
                         +---------------------------+             |
                         | + Lease(rentalUnit: RentalUnit, tenant: Tenant, startDate: LocalDate, endDate: LocalDate)|
                         | + getLeaseNumber(): int    |             |
                         | + getStartDate(): LocalDate|             |
                         | + getEndDate(): LocalDate  |             |
                         | + getRentalUnit(): RentalUnit|           |
                         | + getTenant(): Tenant      |             |
                         | + isActive(): boolean      |             |
                         | + setActive(active: boolean)|            |
                         |                             |            |
                         +-----------------------------+            |
                                                                    |
                         +---------------------------------------------+
                         |
                         |
                         |
           +---------------------------+
           |     RentalUnitService       |
           +---------------------------+ |
           | - rentalUnits: List<RentalUnit>|
           | - id: int                   |
           |                             |
           | + RentalUnitService()       |
           | + addRentalUnit(rentalUnit: RentalUnit): String |
           | + removeRentalUnit(id: int): String |
           | + getAllRentalUnits(): List<RentalUnit>|
           | + getVacantUnits(): List<RentalUnit>|
           | + getRentalUnit(address: String): RentalUnit |
           | + displayAllProperties(): void |
           | + displayAllTenants(): void |
           | + displayRentedUnits(): void|
           | + displayVacantUnits(): void|
           |                             |
           +-----------------------------+

Legend:
+ for public
- for private
() for constructor

```

## Design Patterns Used
### The rental management system uses the following design patterns:

1. Singleton pattern: The RentalUnitService class is implemented using the singleton pattern to ensure that only one instance of the class is created and used throughout the system.
2. Factory pattern: The Lease class uses the factory pattern to create lease objects.
3. Observer pattern: The LeaseService class uses the observer pattern to notify the rental unit service when a lease is ended.
 
## Project Directory Structure : 
``` 
com.management.rental/
├── out/ 
├── main/
│   └── Main.java
├── application/
├── data/
├── presentation/
└── tests/ 
```

## Running the Program
To run the program, open the project in an IDE such as Eclipse or IntelliJ and run the Main class. Alternatively, the program can be run from the command line using the following command:

### Compile the code : 
```bash
javac -d out main/Main.java
```

### Run the code :
```bash
 java -cp out main.Main
```









