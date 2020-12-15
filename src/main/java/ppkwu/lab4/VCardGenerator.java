package ppkwu.lab4;

import ezvcard.*;

public class VCardGenerator {

    public void generateVCard(Contractor contractor){

        VCard vcard = new VCard();

        vcard.setFormattedName(contractor.name);
        vcard.addTitle(contractor.name);
        vcard.addTelephoneNumber(contractor.telephone);
        vcard.addEmail(contractor.email);
        vcard.addUrl(contractor.sameAs);

        System.out.println(vcard);
    }

}
