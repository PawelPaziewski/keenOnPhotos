package pl.paziewski.keenonphotos.photos;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.paziewski.keenonphotos.ValidationResult;

import java.io.IOException;
import java.security.Principal;

@Controller
@AllArgsConstructor
class PhotoController {

    private final PhotoFacade facade;

    @GetMapping("/addphoto")
    String addPhoto(Model model) throws IOException {
        model.addAttribute(new PhotoDto());
        return "add_photo";
    }


    @PostMapping("/upload")
    String upload(Principal principal, @RequestParam("file") MultipartFile file, PhotoDto dto, RedirectAttributes attributes) throws IOException {
        dto.setPhoto(file);
        dto.setOwnerUsername(principal.getName());
        ValidationResult result = facade.addPhoto(dto);
        if (result.isValid()) {
            attributes.addFlashAttribute("infos", result.getMessages());
            return "redirect:/home";
        } else {
            attributes.addFlashAttribute("errors", result.getMessages());
            return "redirect:/addphoto";
        }
    }
}
