package controller;

import model.*;

import java.util.List;

public interface RentalManager {
    boolean addRentalAgreement(RentalAgreement agreement); // Adds a new agreement
    boolean updateRentalAgreement(String agreementId, RentalAgreement updatedAgreement); // Updates an existing agreement
    boolean deleteRentalAgreement(String agreementId); // Deletes an agreement
    List<RentalAgreement> getAllRentalAgreements(); // Returns all agreements
    List<RentalAgreement> getRentalAgreementsByOwnerName(String ownerName); // Finds agreements by owner name
    List<RentalAgreement> getRentalAgreementsByPropertyAddress(String address); // Finds agreements by property address
    List<RentalAgreement> getRentalAgreementsByStatus(RentalAgreement.RentalStatus status); // Finds agreements by status
    List<Tenant> getAllTenants();
    List<Host> getAllHosts();
    List<Owner> getAllOwners();
    List<ResidentialProperty> getAllResidentialProperties();
    List<CommercialProperty> getAllCommercialProperties();
}
