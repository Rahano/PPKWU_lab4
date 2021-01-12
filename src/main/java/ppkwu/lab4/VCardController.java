package ppkwu.lab4;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VCardController {

    @RequestMapping(path = "/getVCards")
    public void publishVCards(@RequestParam(value = "service") String service, @RequestParam(value = "service") int number, HttpServletResponse response) throws IOException {

        String url = "https://panoramafirm.pl/szukaj?k=";
        url += service + "&l=";

        Document document = Jsoup.connect(url).get();

        Gson gson = new Gson();
        VCardGenerator vCardGenerator = new VCardGenerator();
        Elements elements = document.select("script");
        List<Contractor> contractors = new ArrayList<>();
        for (Element element : elements) {
            if (element.attr("type").equals("application/ld+json")) {
                Contractor contractor =  gson.fromJson(element.data(), Contractor.class);
                if(contractor.name != null){
                    contractors.add(gson.fromJson(element.data(), Contractor.class));
                    System.out.println(contractors.get(0));
                }
            }
        }
        if(contractors.get(number) != null)
        vCardGenerator.generateVCard(contractors.get(number), response);
    }
    @RequestMapping(path = "/getSite")
    public ModelAndView publishSite(@RequestParam(value = "service") String service, HttpServletResponse response) throws IOException {

        String url = "https://panoramafirm.pl/szukaj?k=";
        url += service + "&l=";

        Document document = Jsoup.connect(url).get();

        Gson gson = new Gson();
        VCardGenerator vCardGenerator = new VCardGenerator();
        Elements elements = document.select("script");
        List<Contractor> contractors = new ArrayList<>();
        for (Element element : elements) {
            if (element.attr("type").equals("application/ld+json")) {
                Contractor contractor =  gson.fromJson(element.data(), Contractor.class);
                contractor.addVCardButton();
                if(contractor.name != null)
                    contractors.add(contractor);
                }
            }
        String data = gson.toJson(contractors);
        return new ModelAndView("index", "string", data);
        }
    }

