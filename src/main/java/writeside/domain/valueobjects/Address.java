package writeside.domain.valueobjects;

public class Address {
    private final String street;
    private final String zip;
    private final String country;
    private final String city;


    public Address(String street, String zip, String country, String city) {
        this.street = street;
        this.zip = zip;
        this.country = country;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }
}
