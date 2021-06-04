package pl.paziewski.keenonphotos.photos;

import lombok.AllArgsConstructor;
import pl.paziewski.keenonphotos.ValidationResult;

import java.io.IOException;

@AllArgsConstructor
class PhotoFacade {

    private final PhotoValidator validator;
    private final PhotoRepository repository;
    private final PhotoHelper helper;

    ValidationResult addPhoto(PhotoDto dto) throws IOException {
        ValidationResult result = validator.validatePhoto(dto);
        if (result.isValid()) {
            Photo photo = helper.mapToPhoto(dto);
            repository.save(photo);
        }
        return result;
    }
}
