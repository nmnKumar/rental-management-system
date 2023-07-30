package application;

import java.time.LocalDate;

public class Lease {
    private int id;
    private RentalUnit rentalUnit;
    private LocalDate startDate;
    private LocalDate endDate;
    private double monthlyRent;
    private boolean isActive;

    public Lease(int id, RentalUnit rentalUnit, LocalDate startDate, LocalDate endDate, double monthlyRent) {
        this.id = id;
        this.rentalUnit = rentalUnit;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyRent = monthlyRent;
        this.isActive = endDate.isAfter(LocalDate.now()); // set isActive to true if the endDate is in the future
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RentalUnit getRentalUnit() {
        return rentalUnit;
    }

    public void setRentalUnit(RentalUnit rentalUnit) {
        this.rentalUnit = rentalUnit;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    @Override
    public String toString() {
        return "Lease{" +
                "id='" + this.getId() + '\'' +
                ", rental unit='" +  this.rentalUnit+ '\'' +
                ", start date='" + this.startDate + '\'' +
                ", end date ='" + this.endDate + '\'' +
                ", is active ='" + this.isActive + '\'' +
                '}';
    }


}
