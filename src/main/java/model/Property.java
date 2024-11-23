package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Property {
    public enum Status {
        AVAILABLE, RENTED, UNDER_MAINTENANCE
    }

    private String id;
    private String address;
    private double price;
    private Status status;
    private Owner owner;
    private List<Host> hosts;

    public Property() {
    }

    public Property(String propertyId) {
        this.id = propertyId;
    }

    public Property(String id, String address, double price, Status status, Owner owner) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.status = (status != null) ? status : Status.AVAILABLE;
        this.owner = owner;
        this.hosts = new ArrayList<Host>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }

    public List<Host> getHosts() {
        return hosts;
    }
}
