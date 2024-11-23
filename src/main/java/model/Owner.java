package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Owner extends Person{
    private List<Property> propertiesOwned;
    private List<Host> hostsManaging;
    private List<RentalAgreement> rentalAgreements;

    public Owner() {
    }

    public Owner(String id) {
        super(id);
    }

    public Owner(String id, String fullName, Date dateOfBirth, String contactInfo, List<Property> propertiesOwned, List<Host> hostsManaging, List<RentalAgreement> rentalAgreements) {
        super(id, fullName, dateOfBirth, contactInfo);
        this.propertiesOwned = propertiesOwned;
        this.hostsManaging = hostsManaging;
        this.rentalAgreements = rentalAgreements;
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

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDob = dateFormat.format(getDateOfBirth());

        return getId() + " | " + getFullName() + " | " + formattedDob + " | " + getContactInfo() + " | " +
                propertiesToString() + " | " + hostsToString() + " | " + rentalAgreementsToString();
    }

    private String propertiesToString() {
        return propertiesOwned.stream()
                .map(Property::getId)
                .collect(Collectors.joining(","));
    }

    private String hostsToString() {
        return hostsManaging.stream()
                .map(Host::getId)
                .collect(Collectors.joining(","));
    }

    private String rentalAgreementsToString() {
        return rentalAgreements.stream()
                .map(RentalAgreement::getId)
                .collect(Collectors.joining(","));
    }
}
