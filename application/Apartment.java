package application;

public class Apartment extends RentalUnit {
    private boolean hasLaundry;
    private boolean hasParking;
    private boolean hasElevator;

    public Apartment(int id, String address, double monthlyRent, int numberOfRooms, int numberOfBathrooms, boolean hasLaundry, boolean hasParking, boolean hasElevator) {
        super(id, address, monthlyRent, numberOfRooms, numberOfBathrooms);
        this.hasLaundry = hasLaundry;
        this.hasParking = hasParking;
        this.hasElevator = hasElevator;
    }

    public boolean isHasLaundry() {
        return hasLaundry;
    }

    public void setHasLaundry(boolean hasLaundry) {
        this.hasLaundry = hasLaundry;
    }

    public boolean isHasParking() {
        return hasParking;
    }

    public void setHasParking(boolean hasParking) {
        this.hasParking = hasParking;
    }

    public boolean isHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(boolean hasElevator) {
        this.hasElevator = hasElevator;
    }

    @Override
    public String getType() {
        return "Apartment";
    }

    @Override
    public double getRentalPrice() {
        double basePrice = super.getRentalPrice();
        double laundryPrice = hasLaundry ? 50 : 0;
        double parkingPrice = hasParking ? 100 : 0;
        double elevatorPrice = hasElevator ? 200 : 0;
        return basePrice + laundryPrice + parkingPrice + elevatorPrice;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "id='" + this.getId() + '\'' +
                ", address='" +  this.getAddress()+ '\'' +
                ", monthly rent='" +this.getMonthlyRent()  + '\'' +
                ", no. of rooms ='" + this.getNumberOfRooms() + '\'' +
                ", no. of bathrooms ='" + this.getNumberOfBathrooms() + '\'' +
                ", price ='" + this.getRentalPrice() + '\'' +
                '}';
    }
}
