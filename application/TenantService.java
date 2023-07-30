package application;

import java.util.ArrayList;
import java.util.List;

public class TenantService {

    private List<Tenant> tenants;

    public TenantService() {
        this.tenants = new ArrayList<>();
    }

    public void addTenant(String name, String phone, String email, String occupation) {
        Tenant tenant = new Tenant(name, phone, email,occupation);
        this.tenants.add(tenant);
    }


    public void removeTenant(Tenant tenant) {
        this.tenants.remove(tenant);
    }

    public List<Tenant> getAllTenants() {
        return this.tenants;
    }




    public Tenant getTenantByName(String name) {
        for (Tenant tenant : this.tenants) {
            if (tenant.getName().equals(name)) {
                return tenant;
            }
        }
        return null;
    }

    public List<Tenant> getTenantsByOccupation(String occupation) {
        List<Tenant> matchingTenants = new ArrayList<>();
        for (Tenant tenant : this.tenants) {
            if (tenant.getOccupation().equals(occupation)) {
                matchingTenants.add(tenant);
            }
        }
        return matchingTenants;
    }
}
