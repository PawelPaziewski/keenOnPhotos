package pl.paziewski.keenonphotos.photos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter(AccessLevel.PACKAGE)
@Setter(AccessLevel.PACKAGE)
class PhotoDto {
    private String title;
    private String description;
    private String cameraParameters;
    private String location;
    private MultipartFile photo;
    private String ownerUsername;
}
