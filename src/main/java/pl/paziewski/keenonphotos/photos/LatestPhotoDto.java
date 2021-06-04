package pl.paziewski.keenonphotos.photos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class LatestPhotoDto {
    String image;
    String uploaded;
    String title;
    String description;
}
