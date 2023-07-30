package application;

public class Condo extends RentalUnit {
    private double hoaFee;

    public Condo(int id, String address, double monthlyRent, int numberOfRooms, int numberOfBathrooms, double hoaFee) {
        super(id, address, monthlyRent, numberOfRooms, numberOfBathrooms);
        this.hoaFee = hoaFee;
    }

    public double getHoaFee() {
        return hoaFee;
    }

    public void setHoaFee(double hoaFee) {
        this.hoaFee = hoaFee;
    }

    @Override
    public String getType() {
        return "Condo";
    }

    @Override
    public double getRentalPrice() {
        return super.getMonthlyRent() + hoaFee;
    }

    @Override
    public String toString() {
        return "Condo{" +
                "id='" + this.getId() + '\'' +
                ", address='" +  this.getAddress()+ '\'' +
                ", monthly rent='" +this.getMonthlyRent()  + '\'' +
                ", no. of rooms ='" + this.getNumberOfRooms() + '\'' +
                ", no. of bathrooms ='" + this.getNumberOfBathrooms() + '\'' +
                ", price ='" + this.getRentalPrice() + '\'' +
                '}';
    }
}
