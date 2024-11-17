package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tenant extends Person{
    private List<RentalAgreement> rentalAgreements;
    private List<Payment> paymentRecords;

    public Tenant() {
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
}
