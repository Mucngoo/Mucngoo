package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Host extends Person{
    private List<Property> propertiesManaged;
    private List<Owner> cooperatingOwners;
    private List<RentalAgreement> rentalAgreements;

    public Host() {
    }

    public Host(String hostId) {
        super(hostId);
    }

    public Host(String id, String fullName, Date dateOfBirth, String contactInfo, List<Property> propertiesManaged, List<Owner> cooperatingOwners, List<RentalAgreement> rentalAgreements) {
        super(id, fullName, dateOfBirth, contactInfo);
        this.propertiesManaged = propertiesManaged;
        this.cooperatingOwners = cooperatingOwners;
        this.rentalAgreements = rentalAgreements;
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

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDob = dateFormat.format(getDateOfBirth());

        // Build the string
        return getId() + " | " + getFullName() + " | " + formattedDob + " | " + getContactInfo() + " | " +
                propertiesToString() + " | " + ownersToString() + " | " + rentalAgreementsToString();
    }

    private String propertiesToString() {
        return propertiesManaged.stream()
                .map(Property::getId) // Assuming Property has a `getId` method
                .collect(Collectors.joining(","));
    }

    private String ownersToString() {
        return cooperatingOwners.stream()
                .map(Owner::getId) // Assuming Owner has a `getId` method
                .collect(Collectors.joining(","));
    }

    private String rentalAgreementsToString() {
        return rentalAgreements.stream()
                .map(RentalAgreement::getId) // Assuming RentalAgreement has a `getId` method
                .collect(Collectors.joining(","));
    }
}
