package pl.paziewski.keenonphotos.photos;

import org.joda.time.LocalDateTime;

import java.io.IOException;
import java.util.Base64;

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

    static LatestPhotoDto convertToLatestPhotoDto(Photo photo) {
        return new LatestPhotoDto(
                "data:image/png;base64," + Base64.getMimeEncoder().encodeToString(photo.getPhoto()),
                photo.getUploaded().toString(),
                photo.getTitle(),
                photo.getDescription()
        );
    }
}
