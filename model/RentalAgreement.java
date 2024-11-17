package model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RentalAgreement {
    public enum RentalPeriod {
        DAILY, WEEKLY, MONTHLY
    }
    public enum RentalStatus {
        NEW, ACTIVE, COMPLETE
    }

    private String id;
    private Map<Tenant, List<Tenant>> tenants; // key: tenant, value: list of sub-tenants
    private Property propertyLeased;
    private RentalPeriod period;
    private Date contractDate;
    private double rentalFee;
    private RentalStatus status;

    public RentalAgreement() {
    }

    public RentalAgreement(String id, Property propertyLeased, RentalPeriod period, Date contractDate, double rentalFee, RentalStatus status) {
        this.id = id;
        this.propertyLeased = propertyLeased;
        this.period = period;
        this.contractDate = contractDate;
        this.rentalFee = rentalFee;
        this.status = status;
        this.tenants = new HashMap<Tenant, List<Tenant>>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setTenants(Map<Tenant, List<Tenant>> tenants) { this.tenants = tenants; }

    public Map<Tenant, List<Tenant>> getTenants() {
        return this.tenants;
    }

    public void setPropertyLeased(Property propertyLeased) {
        this.propertyLeased = propertyLeased;
    }

    public Property getPropertyLeased() {
        return this.propertyLeased;
    }

    public void setPeriod(RentalPeriod period) {
        this.period = period;
    }

    public RentalPeriod getPeriod() {
        return this.period;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }

    public Date getContractDate() {
        return this.contractDate;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public double getRentalFee() {
        return this.rentalFee;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }

    public RentalStatus getStatus() {
        return this.status;
    }
}
