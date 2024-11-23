package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Tenant extends Person{
    private List<RentalAgreement> rentalAgreements;
    private List<Payment> paymentRecords;

    public Tenant() {
    }

    public Tenant(String tenantId) {
        super(tenantId);
    }

    public Tenant(String id, String fullName, Date dateOfBirth, String contactInfo) {
        super(id, fullName, dateOfBirth, contactInfo);
        this.rentalAgreements = new ArrayList<RentalAgreement>();
        this.paymentRecords = new ArrayList<Payment>();
    }

    public void addRentalAgreement(RentalAgreement rentalAgreement) {
        this.rentalAgreements.add(rentalAgreement);
    }

    public List<RentalAgreement> getRentalAgreements() {
        return this.rentalAgreements;
    }

    public void addPaymentRecord(Payment payment) {
        this.paymentRecords.add(payment);
    }

    public List<Payment> getPaymentRecords() {
        return this.paymentRecords;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDob = dateFormat.format(getDateOfBirth());

        return getId() + " | " + getFullName() + " | " + formattedDob + " | " + getContactInfo() + " | " +
                rentalAgreementsToString() + " | " + paymentRecordsToString();
    }

    private String rentalAgreementsToString() {
        return rentalAgreements.stream()
                .map(RentalAgreement::getId)
                .collect(Collectors.joining(","));
    }

    private String paymentRecordsToString() {
        return paymentRecords.stream()
                .map(Payment::getPaymentId)
                .collect(Collectors.joining(","));
    }
}
