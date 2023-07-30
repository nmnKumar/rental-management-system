package application;

public class House extends RentalUnit {
    private boolean hasYard;

    public House(int id, String address, double monthlyRent, int numberOfRooms, int numberOfBathrooms, boolean hasYard) {
        super(id, address, monthlyRent, numberOfRooms, numberOfBathrooms);
        this.hasYard = hasYard;
    }

    public boolean hasYard() {
        return hasYard;
    }

    public void setHasYard(boolean hasYard) {
        this.hasYard = hasYard;
    }

    @Override
    public String getType() {
        return "House";
    }

    @Override
    public double getRentalPrice() {
        double rentalPrice = super.getRentalPrice();
        if (hasYard) {
            rentalPrice += 50.0;
        }
        return rentalPrice;
    }

    @Override
    public String toString() {
        return "House{" +
                "id='" + this.getId() + '\'' +
                ", address='" +  this.getAddress()+ '\'' +
                ", monthly rent='" +this.getMonthlyRent()  + '\'' +
                ", no. of rooms ='" + this.getNumberOfRooms() + '\'' +
                ", no. of bathrooms ='" + this.getNumberOfBathrooms() + '\'' +
                ", price ='" + this.getRentalPrice() + '\'' +
                '}';
    }
}
