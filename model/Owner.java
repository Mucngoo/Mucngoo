package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Owner extends Person{
    private List<Property> propertiesOwned;
    private List<Host> hostsManaging;
    private List<RentalAgreement> rentalAgreements;

    public Owner() {
    }

    public Owner(String id, String fullName, Date dateOfBirth, String contactInfo) {
        super(id, fullName, dateOfBirth, contactInfo);
        this.propertiesOwned = new ArrayList<Property>();
        this.hostsManaging = new ArrayList<Host>();
        this.rentalAgreements = new ArrayList<RentalAgreement>();
    }

    public void addProperty(Property property) {
        this.propertiesOwned.add(property);
    }

    public List<Property> getPropertiesOwned() {
        return this.propertiesOwned;
    }

    public void addHost(Host host) {
        this.hostsManaging.add(host);
    }

    public List<Host> getHostsManaging() {
        return this.hostsManaging;
    }

    public void addRentalAgreement(RentalAgreement rentalAgreement) {
        this.rentalAgreements.add(rentalAgreement);
    }

    public List<RentalAgreement> getRentalAgreements() {
        return this.rentalAgreements;
    }
}
