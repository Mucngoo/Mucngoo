package model;

public class CommercialProperty extends Property{
    private String businessType;
    private int parkingSpaces;
    private double squareFootage;

    public CommercialProperty() {
    }

    public CommercialProperty(String propertyId) {
        super(propertyId);
    }

    public CommercialProperty(String id, String address, double price, Status status, Owner owner) {
        super(id, address, price, status, owner);
    }

    public CommercialProperty(String id, String address, double price, Status status, Owner owner, String businessType, int parkingSpaces, double squareFootage) {
        super(id, address, price, status, owner);
        this.businessType = businessType;
        this.parkingSpaces = parkingSpaces;
        this.squareFootage = squareFootage;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public void setParkingSpaces(int parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public int getParkingSpaces() {
        return this.parkingSpaces;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public double getSquareFootage() {
        return this.squareFootage;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + businessType + " | " + parkingSpaces + " | " + squareFootage;
    }
}
