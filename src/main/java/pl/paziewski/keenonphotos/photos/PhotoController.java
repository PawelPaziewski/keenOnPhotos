package pl.paziewski.keenonphotos.photos;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
    String upload(Principal principal, @RequestParam("file") MultipartFile file, PhotoDto dto) throws IOException {
        dto.setPhoto(file);
        dto.setOwnerUsername(principal.getName());
        ValidationResult validationResult = facade.addPhoto(dto);
        return validationResult.isValid() ? "redirect:/home" : "redirect:/addphoto";
    }
}
