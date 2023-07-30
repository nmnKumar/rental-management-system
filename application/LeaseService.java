package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LeaseService {
    private List<Lease> leases;

    public LeaseService() {
        this.leases = new ArrayList<>();
    }

    public void addLease(Lease lease) {
        leases.add(lease);
    }

    public List<Lease> getLeases() {
        return leases;
    }

    public List<Lease> getActiveLeases() {
        List<Lease> activeLeases = new ArrayList<>();
        for (Lease lease : leases) {
            if (lease.isActive() && LocalDate.now().isBefore(lease.getEndDate())) {
                activeLeases.add(lease);
            }
        }
        return activeLeases;
    }

    public void endLease(Lease lease) {
        lease.setActive(false);
    }
}
