package model;

public class ResidentialProperty extends Property{
    private int bedrooms;
    private boolean hasGarden;
    private boolean petFriendly;

    public ResidentialProperty() {
    }

    public ResidentialProperty(String propertyId) {
        super(propertyId);
    }

    public ResidentialProperty(String id, String address, double price, Status status, Owner owner) {
        super(id, address, price, status, owner);
    }

    public ResidentialProperty(String id, String address, double price, Status status, Owner owner, int bedrooms, boolean hasGarden, boolean petFriendly) {
        super(id, address, price, status, owner);
        this.bedrooms = bedrooms;
        this.hasGarden = hasGarden;
        this.petFriendly = petFriendly;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBedrooms() {
        return this.bedrooms;
    }

    public void setHasGarden(boolean hasGarden) {
        this.hasGarden = hasGarden;
    }

    public boolean getHasGarden() {
        return this.hasGarden;
    }

    public void setPetFriendly(boolean petFriendly) {
        this.petFriendly = petFriendly;
    }

    public boolean getPetFriendly() {
        return this.petFriendly;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + bedrooms + " | " + hasGarden + " | " + petFriendly;
    }
}
