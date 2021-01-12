package ppkwu.lab4;

import java.net.URL;

public class Contractor {

    String name;
    String telephone;
    String email;
    String sameAs;
    Address address;
    String VCardButton;

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
    public void addVCardButton(int number, String service){
        VCardButton = "<form method=\"post\" action=\"/getVCards\">"
                      + "<input type=\"hidden\" name=\"service\" value=\""
                      + service
                      + "\">"
                      + "<input type=\"hidden\" name=\"number\" value=\""
                      + number
                      + "\">"
                      + "<button type=\"submit\">Download VCard</button>\n"
                      + "</form>";
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
