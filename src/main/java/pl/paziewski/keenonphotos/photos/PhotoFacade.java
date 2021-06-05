package pl.paziewski.keenonphotos.photos;

import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.domain.*;
import pl.paziewski.keenonphotos.ValidationResult;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
class PhotoFacade {

    private final PhotoValidator validator;
    private final PhotoRepository repository;
    private final PhotoHelper helper;

    ValidationResult addPhoto(UploadPhotoDto dto) throws IOException {
        ValidationResult result = validator.validatePhoto(dto);
        if (result.isValid()) {
            Photo photo = helper.mapToPhoto(dto);
            repository.save(photo);
        }
        return result;
    }

    public Page<PhotoDto> getLatestPhotos(int pageNumber) {
        Sort sort = Sort.by(Sort.Direction.DESC, "uploaded");
        Pageable paging = PageRequest.of(pageNumber, 3, sort);
        Page<Photo> page = repository.findAll(paging);
        List<PhotoDto> converted = page.getContent()
                .stream()
                .map(PhotoHelper::convertToLatestPhotoDto)
                .collect(Collectors.toList());
        return new PageImpl<>(converted, paging, page.getTotalElements());
    }

    Optional<PhotoDto> getPhoto(ObjectId id) {
        return repository.findById(id)
                .map(PhotoHelper::convertToLatestPhotoDto);
    }
}
