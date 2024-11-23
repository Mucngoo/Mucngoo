package org.example;

import model.Host;
import model.Owner;
import model.Payment;
import util.FileHandler;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Host> hosts = FileHandler.loadFromHost("data/Host.txt");
        for (Host host : hosts) {
            System.out.println(host);
        }

        System.out.println();

        List<Payment> payments = FileHandler.loadFromPayment("data/Payment.txt");
        for (Payment payment : payments) {
            System.out.println(payment);
        }

        System.out.println();

        List<Owner> owners = FileHandler.loadFromOwner("data/Owner.txt");
        for (Owner owner : owners) {
            System.out.println(owner);
        }
    }
}