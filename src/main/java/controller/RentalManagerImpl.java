package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RentalManagerImpl implements RentalManager{
    private List<RentalAgreement> rentalAgreements;

    public RentalManagerImpl() {
        rentalAgreements = new ArrayList<RentalAgreement>();
    }

    @Override
    public boolean addRentalAgreement(RentalAgreement agreement) {
        if (agreement == null || rentalAgreements.contains(agreement)) {
            return false; // Agreement is null or already exists
        }
        return rentalAgreements.add(agreement);
    }

    @Override
    public boolean updateRentalAgreement(String agreementId, RentalAgreement updatedAgreement) {
        for (int i = 0; i < rentalAgreements.size(); i++) {
            if (rentalAgreements.get(i).getId().equals(agreementId)) {
                rentalAgreements.set(i, updatedAgreement);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteRentalAgreement(String agreementId) {
        return rentalAgreements.removeIf(agreement -> agreement.getId().equals(agreementId));
    }

    @Override
    public List<RentalAgreement> getAllRentalAgreements() {
        return new ArrayList<>(rentalAgreements);
    }

    @Override
    public List<RentalAgreement> getRentalAgreementsByOwnerName(String ownerName) {
        return rentalAgreements.stream()
                .filter(agreement -> agreement.getPropertyLeased() != null &&
                        agreement.getPropertyLeased().getOwner() != null &&
                        agreement.getPropertyLeased().getOwner().getFullName().equals(ownerName))
                .collect(Collectors.toList());
    }

    @Override
    public List<RentalAgreement> getRentalAgreementsByPropertyAddress(String address) {
        return rentalAgreements.stream()
                .filter(agreement -> agreement.getPropertyLeased() != null &&
                        agreement.getPropertyLeased().getAddress().equals(address))
                .collect(Collectors.toList());
    }

    @Override
    public List<RentalAgreement> getRentalAgreementsByStatus(RentalAgreement.RentalStatus status) {
        return rentalAgreements.stream()
                .filter(agreement -> agreement.getStatus() == status)
                .collect(Collectors.toList());
    }
}
