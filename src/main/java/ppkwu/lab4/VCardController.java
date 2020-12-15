package ppkwu.lab4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class VCardController {

    @RequestMapping(path = "/getVCards")
    public void publishVCards(@RequestParam(value = "service") String service) throws IOException {

        String url = "https://panoramafirm.pl/szukaj?k=";
        url += service + "&l=";

        Document document = Jsoup.connect(url).get();
        //System.out.println(document);

    }

}
