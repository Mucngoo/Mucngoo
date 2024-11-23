package util;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import model.*;

public class FileHandler<T> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    // Reusable helper method to skip the first line of a file
    private static BufferedReader getReaderSkippingFirstLine(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        br.readLine(); // Skip the first line (header)
        return br;
    }

    // Helper method to parse a single date
    public static Date parseDate(String dateStr) {
        if (dateStr == null || dateStr.trim().isEmpty()) {
            System.err.println("Date string is null or empty: " + dateStr);
            return null; // Handle empty or null date strings
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            System.err.println("Error parsing date: " + dateStr + " - " + e.getMessage());
            return null;
        }
    }

    public static List<Host> loadFromHost(String filename) {
        List<Host> hosts = new ArrayList<>();
        try (BufferedReader br = getReaderSkippingFirstLine(filename)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                List<Property> properties = ParseUtil.parseProperties(data[4]);
                List<Owner> owners = ParseUtil.parseOwners(data[5]);
                List<RentalAgreement> rentalAgreements = ParseUtil.parseRentalAgreements(data[6]);
                Date dob = parseDate(data[2]); // Parsing date for DOB

                Host host = new Host(
                        data[0], data[1], dob, data[3], // Using parsed DOB here
                        properties,
                        owners,
                        rentalAgreements
                );
                hosts.add(host);
            }
        } catch (IOException e) {
            System.err.println("Error loading Hosts: " + e.getMessage());
        }
        return hosts;
    }

    public static void saveToHost(String filename, List<Host> hosts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Host host : hosts) {
                String properties = String.join(",",
                        host.getPropertiesManaged().stream().map(Property::getId).toList());
                String owners = String.join(",",
                        host.getCooperatingOwners().stream().map(Owner::getId).toList());
                String rentalAgreements = String.join(",",
                        host.getRentalAgreements().stream().map(RentalAgreement::getId).toList());

                bw.write(String.join(",",
                        host.getId(), host.getFullName(), host.getDateOfBirth().toString(),
                        host.getContactInfo(), properties, owners, rentalAgreements));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving hosts: " + e.getMessage());
        }
    }

    public static List<Owner> loadFromOwner(String filename) {
        List<Owner> owners = new ArrayList<>();
        try (BufferedReader br = getReaderSkippingFirstLine(filename)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                Date dob = parseDate(data[2]); // Parse the date
                List<Property> properties = ParseUtil.parseProperties(data[4]);
                List<Host> hosts = ParseUtil.parseHosts(data[5]);
                List<RentalAgreement> rentalAgreements = ParseUtil.parseRentalAgreements(data[6]);

                Owner owner = new Owner(data[0], data[1], dob, data[3], properties, hosts, rentalAgreements);
                owners.add(owner);
            }
        } catch (IOException e) {
            System.err.println("Error loading Owners: " + e.getMessage());
        }
        return owners;
    }

    public static void saveToOwner(String filename, List<Owner> owners) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Owner owner : owners) {
                String properties = String.join(",",
                        owner.getPropertiesOwned().stream().map(Property::getId).toList());
                String hosts = String.join(",",
                        owner.getHostsManaging().stream().map(Host::getId).toList());
                String rentalAgreements = String.join(",",
                        owner.getRentalAgreements().stream().map(RentalAgreement::getId).toList());

                bw.write(String.join(",",
                        owner.getId(), owner.getFullName(), owner.getDateOfBirth().toString(),
                        owner.getContactInfo(), properties, hosts, rentalAgreements));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving Owners: " + e.getMessage());
        }
    }

    public static List<Payment> loadFromPayment(String filename) {
        List<Payment> payments = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                Date date = parseDate(data[2]); // Parse the date
                Payment payment = new Payment(data[0], Double.parseDouble(data[1]), date, data[3]);
                payments.add(payment);
            }
        } catch (IOException e) {
            System.err.println("Error loading Payments: " + e.getMessage());
        }
        return payments;
    }

    public static void saveToPayment(String filename, List<Payment> payments) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Payment payment : payments) {
                String date = DATE_FORMAT.format(payment.getDate()); // Convert Date to String
                bw.write(String.join("|", payment.getPaymentId(), String.valueOf(payment.getAmount()), date, payment.getPaymentMethod()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving Payments: " + e.getMessage());
        }
    }
}
