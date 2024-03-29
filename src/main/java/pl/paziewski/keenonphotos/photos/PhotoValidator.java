package pl.paziewski.keenonphotos.photos;

import org.springframework.web.multipart.MultipartFile;
import pl.paziewski.keenonphotos.ValidationResult;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

class PhotoValidator {
    ValidationResult validatePhoto(UploadPhotoDto dto) {
        Optional<String> titleValidation = validateTitle(dto);
        List<String> validationResult = new ArrayList<>(validateImage(dto.getPhoto()));
        titleValidation.ifPresent(validationResult::add);
        if (validationResult.isEmpty()) {
            validationResult.add("Successfully added a photo");
            return new ValidationResult(true, validationResult);
        } else {
            return new ValidationResult(false, validationResult);
        }
    }

    private List<String> validateImage(MultipartFile image) {
        LinkedList<String> result = new LinkedList<>();
        if (image.isEmpty()) {
            result.add("Image mustn't be empty");
        } else if (!image.getContentType().contains("image")) {
            result.add("Type of file have to be image");
        }
        return result;
    }

    private Optional<String> validateTitle(UploadPhotoDto dto) {
        if (dto.getTitle() == null || dto.getTitle().isEmpty()) {
            return Optional.of("Title mustn't be empty");
        }
        return Optional.empty();
    }
}
