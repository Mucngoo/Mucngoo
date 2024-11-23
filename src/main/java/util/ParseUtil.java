package util;

import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ParseUtil {

    static List<Owner> parseOwners(String data) {
        List<Owner> owners = new ArrayList<>();
        String[] ownerIds = data.split(",");
        for (String ownerId : ownerIds) {
            owners.add(new Owner(ownerId));
        }
        return owners;
    }

    static List<Host> parseHosts(String data) {
        List<Host> hosts = new ArrayList<>();
        String[] hostIds = data.split(",");
        for (String hostId : hostIds) {
            hosts.add(new Host(hostId));
        }
        return hosts;
    }

    static List<RentalAgreement> parseRentalAgreements(String data) {
        List<RentalAgreement> agreements = new ArrayList<>();
        String[] agreementIds = data.split(",");
        for (String agreementId : agreementIds) {
            agreements.add(new RentalAgreement(agreementId));
        }
        return agreements;
    }

    private static Property.Status parseStatus(String status) {
        return Property.Status.valueOf(status.toUpperCase());
    }

    static List<Property> parseProperties(String data) {
        List<Property> properties = new ArrayList<>();
        String[] propertyIds = data.split(",");
        for (String propertyId : propertyIds) {
            if (propertyId.startsWith("CP")) {
                properties.add(new CommercialProperty(propertyId));
            } else if (propertyId.startsWith("RP")) {
                properties.add(new ResidentialProperty(propertyId));
            } else {
                System.err.println("Unknown property type: " + propertyId);
            }
        }
        return properties;
    }

    private static List<Payment> parsePayments(String data) {
        List<Payment> payments = new ArrayList<>();
        String[] paymentIds = data.split(",");
        for (String paymentId : paymentIds) {
            payments.add(new Payment(paymentId)); // Assuming a constructor with only ID
        }
        return payments;
    }

    static List<Tenant> parseTenants(String data) {
        List<Tenant> tenants = new ArrayList<>();
        String[] tenantIds = data.split(",");
        for (String tenantId : tenantIds) {
            tenants.add(new Tenant(tenantId));
        }
        return tenants;
    }

    private static Map<Tenant, List<Tenant>> parseTenantMap(String mainTenantId, String subTenantIds) {
        Map<Tenant, List<Tenant>> tenantMap = new HashMap<>();
        Tenant mainTenant = new Tenant(mainTenantId); // Assuming a constructor with only ID
        List<Tenant> subTenants = parseTenants(subTenantIds);
        tenantMap.put(mainTenant, subTenants);
        return tenantMap;
    }
}
