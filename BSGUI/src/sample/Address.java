package sample;

public class Address {
    private String country;
    private String town;
    private String address;

    public Address(String country, String town, String address) {
        this.country = country;
        this.town = town;
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String addressForSQLQuery(){
        return "'" + country + "'" + ',' + "'" + town + "'" + ',' + "'" + address + "'" + ',';
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", town='" + town + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
