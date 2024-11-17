package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Host extends Person{
    private List<Property> propertiesManaged;
    private List<Owner> cooperatingOwners;
    private List<RentalAgreement> rentalAgreements;

    public Host() {
    }

    public Host(String id, String fullName, Date dateOfBirth, String contactInfo) {
        super(id, fullName, dateOfBirth, contactInfo);
        this.propertiesManaged = new ArrayList<Property>();
        this.cooperatingOwners = new ArrayList<Owner>();
        this.rentalAgreements = new ArrayList<RentalAgreement>();
    }

    public void addProperty(Property property) {
        this.propertiesManaged.add(property);
    }

    public List<Property> getPropertiesManaged() {
        return this.propertiesManaged;
    }

    public void addCooperatingOwner(Owner owner) {
        this.cooperatingOwners.add(owner);
    }

    public List<Owner> getCooperatingOwners() {
        return this.cooperatingOwners;
    }

    public void addRentalAgreement(RentalAgreement rentalAgreement) {
        this.rentalAgreements.add(rentalAgreement);
    }

    public List<RentalAgreement> getRentalAgreements() {
        return this.rentalAgreements;
    }
}
