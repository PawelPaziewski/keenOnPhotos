package pl.paziewski.keenonphotos.photos;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Setter(AccessLevel.PRIVATE)
@Document(collection = "photos")
class Photo {

    @Id
    private ObjectId _id;
    private String title;
    private String ownerUsername;
    private byte[] photo;
    private String description;
    private LocalDateTime uploaded;
    private String cameraParameters;
    private String location;

    public Photo(String title, String ownerUsername, byte[] photo, String description, LocalDateTime uploaded, String cameraParameters, String location) {
        this.title = title;
        this.ownerUsername = ownerUsername;
        this.photo = photo;
        this.description = description;
        this.uploaded = uploaded;
        this.cameraParameters = cameraParameters;
        this.location = location;
    }
}
