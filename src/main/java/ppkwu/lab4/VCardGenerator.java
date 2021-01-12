package ppkwu.lab4;

import ezvcard.*;
import ezvcard.property.Address;

public class VCardGenerator {

    public void generateVCard(Contractor contractor){

        VCard vcard = new VCard();

        vcard.setFormattedName(contractor.name);
        vcard.addTitle(contractor.name);
        vcard.addTelephoneNumber(contractor.telephone);
        vcard.addEmail(contractor.email);
        vcard.addUrl(contractor.sameAs);

        Address adr = new Address();
        adr.setStreetAddress(contractor.address.streetAddress);
        adr.setLocality(contractor.address.addressLocality);
        adr.setPostalCode(contractor.address.postalCode);
        adr.setCountry(contractor.address.addressCountry);

        vcard.addAddress(adr);

        System.out.println(vcard);
    }

}
