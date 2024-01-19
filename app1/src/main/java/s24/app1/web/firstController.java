package s24.app1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class firstController {

    @RequestMapping("index")
    @ResponseBody
    public String returnIndex() {
        return "This is the main page";
    }

    @RequestMapping("contact")
    @ResponseBody
    public String returnContact() {
        return "This is the contact page";
    }

}
