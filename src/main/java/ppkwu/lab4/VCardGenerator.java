package ppkwu.lab4;

import ezvcard.*;
import ezvcard.property.Address;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class VCardGenerator {

    public void generateVCard(Contractor contractor, HttpServletResponse response) throws IOException {

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

        File vcardFile = generateVCardFile(vcard);
        returnVCFFile(response, vcardFile );

    }
    private File generateVCardFile(VCard vcard) throws IOException {
        String name ="VCard.vcf";
        File vcardFile = new File(name);
        Ezvcard.write(vcard).version(VCardVersion.V3_0).go(vcardFile);
        return vcardFile;
    }

    private void returnVCFFile(HttpServletResponse response, File vcard) throws IOException {
        InputStream inputStream = new FileInputStream(vcard);
        response.setContentType("text/vcard;charset=utf-8");
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }

}
