package writeside.domain;

import writeside.domain.valueobjects.Address;

import java.util.UUID;

public class Customer {
    private UUID customerID;
    private String name;
    private Address address;

    public Customer(UUID customerId, String name, Address address) {
        this.customerID = customerId;
        this.name = name;
        this.address = address;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
