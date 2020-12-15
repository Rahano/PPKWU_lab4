package ppkwu.lab4;

import java.net.URL;

public class Contractor {

    String name;
    String telephone;
    String email;
    String sameAs;
    Address address;

    @Override public String toString() {
        return "Contractor{"
               + "name='"
               + name
               + '\''
               + ", telephone='"
               + telephone
               + '\''
               + ", email='"
               + email
               + '\''
               + ", sameAs="
               + sameAs
               + ", address="
               + address
               + '}';
    }
}
class Address{
    String streetAddress;
    String addressLocality;
    String postalCode;
    String addressCountry;

    @Override public String toString() {
        return "Address{"
               + "streetAddress='"
               + streetAddress
               + '\''
               + ", addressLocality='"
               + addressLocality
               + '\''
               + ", postalCode='"
               + postalCode
               + '\''
               + ", addressCountry='"
               + addressCountry
               + '\''
               + '}';
    }
}
