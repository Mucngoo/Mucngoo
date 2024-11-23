package controller;

import model.*;

import java.util.List;

public interface RentalManager {
    boolean addRentalAgreement(RentalAgreement agreement);
    boolean updateRentalAgreement(String agreementId, RentalAgreement updatedAgreement);
    boolean deleteRentalAgreement(String agreementId);
    List<RentalAgreement> getAllRentalAgreements();
    List<RentalAgreement> getRentalAgreementsByOwnerName(String ownerName);
    List<RentalAgreement> getRentalAgreementsByPropertyAddress(String address);
    List<RentalAgreement> getRentalAgreementsByStatus(RentalAgreement.RentalStatus status);
}
