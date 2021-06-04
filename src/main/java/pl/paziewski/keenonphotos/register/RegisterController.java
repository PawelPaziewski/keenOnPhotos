package pl.paziewski.keenonphotos.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Controller
class RegisterController {

    private final RegistrationFacade facade;

    @GetMapping("/register")
    String registerGet(Model model) {
        model.addAttribute("dto", new RegisterDto());
        return "register";
    }

    @PostMapping("/register")
    String registerPost(RegisterDto dto, Model model) {
        ValidationResult validationResult = facade.addUser(dto);
        if (validationResult.isValid()) {
            return "login";
        } else {
            model.addAttribute("dto", dto);
            return "register";
        }
    }
}
