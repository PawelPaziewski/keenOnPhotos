package pl.paziewski.keenonphotos.photos;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import pl.paziewski.keenonphotos.ValidationResult;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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

    public Page<LatestPhotoDto> getLatestPhotos(int pageNumber) {
        Sort sort = Sort.by(Sort.Direction.DESC, "uploaded");
        Pageable paging = PageRequest.of(pageNumber, 3, sort);
        Page<Photo> page = repository.findAll(paging);
        List<LatestPhotoDto> converted = page.getContent()
                .stream()
                .map(PhotoHelper::convertToLatestPhotoDto)
                .collect(Collectors.toList());
        return new PageImpl<>(converted, paging, page.getTotalElements());
    }
}
