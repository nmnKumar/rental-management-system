package data;

import application.RentalUnit;

import java.util.List;

public interface RentalUnitDatabase {
    List<RentalUnit> getAllUnits();
    RentalUnit getUnitById(int id);
    void addUnit(RentalUnit unit);
    void updateUnit(RentalUnit unit);
    void removeUnit(RentalUnit unit);
}
