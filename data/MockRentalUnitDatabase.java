package data;

import application.RentalUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockRentalUnitDatabase implements RentalUnitDatabase {
    private Map<Integer, RentalUnit> units;

    public MockRentalUnitDatabase() {
        units = new HashMap<>();
    }

    @Override
    public List<RentalUnit> getAllUnits() {
        return new ArrayList<>(units.values());
    }

    @Override
    public RentalUnit getUnitById(int id) {
        return units.get(id);
    }

    @Override
    public void addUnit(RentalUnit unit) {
        int id = units.size() + 1; // get the next ID for the new unit
        unit.setId(id); // set the ID for the new unit
        units.put(id, unit); // add the new unit to the map
    }

    @Override
    public void updateUnit(RentalUnit unit) {
        units.put(unit.getId(), unit);
    }

    @Override
    public void removeUnit(RentalUnit unit) {
        units.remove(unit.getId());
    }
}
