package pl.paziewski.keenonphotos.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
class LoginController {

    @GetMapping("/login")
    String login(Principal principal, RedirectAttributes attributes) {
        if (principal != null) {
            attributes.addFlashAttribute("errors", List.of("You are logged. To login to another account You have to logout first."));
            return "redirect:/home";
        } else {
            return "login";
        }
    }
}
