package pl.paziewski.keenonphotos.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Arrays;

@Controller
public class HomeController {

    @GetMapping("/")
    String home(Principal principal, Model model){
        return "home";
    }


}
