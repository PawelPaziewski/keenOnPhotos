package pl.paziewski.keenonphotos.photos;

import org.joda.time.LocalDateTime;

import java.io.IOException;

class PhotoHelper {

    Photo mapToPhoto(PhotoDto dto) throws IOException {
        return new Photo(
                dto.getTitle(),
                dto.getOwnerUsername(),
                dto.getPhoto().getBytes(),
                dto.getDescription(),
                LocalDateTime.now(),
                dto.getCameraParameters(),
                dto.getLocation()
        );
    }
}
