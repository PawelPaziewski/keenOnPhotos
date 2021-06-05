package pl.paziewski.keenonphotos.photos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bson.types.ObjectId;

@Getter
@AllArgsConstructor
class LatestPhotoDto {
    ObjectId id;
    String image;
    String uploaded;
    String title;
    String description;
    String ownerUsername;
    String cameraParameters;
    String location;
}
