package pl.paziewski.keenonphotos.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.paziewski.keenonphotos.ValidationResult;

import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@Controller
class RegisterController {

    private final RegistrationFacade facade;

    @GetMapping("/register")
    String registerGet(Model model, Principal principal, RedirectAttributes attributes) {
        if (principal != null) {
            attributes.addFlashAttribute("errors", List.of("You are logged in. To register You have to logout first."));
            return "redirect:/home";
        } else {
            model.addAttribute("dto", new RegisterDto());
            return "register";
        }
    }

    @PostMapping("/register")
    String registerPost(RegisterDto dto, Model model, RedirectAttributes attributes) {
        ValidationResult result = facade.addUser(dto);
        if (result.isValid()) {
            attributes.addFlashAttribute("infos", result.getMessages());
            return "redirect:/login";
        } else {
            model.addAttribute("dto", dto);
            attributes.addFlashAttribute("errors", result.getMessages());
            return "redirect:/register";
        }
    }
}
