package pl.paziewski.keenonphotos.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class SecurityControllers {

    @GetMapping("/login")
    String login() {
        return "login";
    }
}
