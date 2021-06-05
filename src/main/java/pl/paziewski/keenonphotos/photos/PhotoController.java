package pl.paziewski.keenonphotos.photos;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.paziewski.keenonphotos.ValidationResult;

import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

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

    @GetMapping("/latestphotos")
    String latest(Model model,
                  @RequestParam("page") Optional<Integer> page) {
        int currentPage = page.orElse(0);
        Page<LatestPhotoDto> photos = facade.getLatestPhotos(currentPage);
        model.addAttribute("page", photos);
        return "latest_photos";
    }

    @GetMapping("/details/{id}")
    String details(@PathVariable String id) {
        System.out.println("RECEIVED ID: " + id);
        return "home";
    }
}
