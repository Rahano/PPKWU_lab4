package ppkwu.lab4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VCardController {

    @RequestMapping(path = "/getVCards")
    public void publishVCards(@RequestParam(value = "service") String service){

        String url = "https://panoramafirm.pl/szukaj?k=";
        url += service + "&l=";

    }

}
