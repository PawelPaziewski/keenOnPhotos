package pl.paziewski.keenonphotos.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home"})
    String home(Principal principal, Model model) {
        return "home";
    }
}
