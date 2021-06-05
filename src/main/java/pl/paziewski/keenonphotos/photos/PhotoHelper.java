package pl.paziewski.keenonphotos.photos;

import org.imgscalr.Scalr;
import org.joda.time.LocalDateTime;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

class PhotoHelper {

    private static final int TARGET_SIZE = 1920;

    Photo mapToPhoto(UploadPhotoDto dto) throws IOException {
        return new Photo(
                dto.getTitle(),
                dto.getOwnerUsername(),
                resizeAndMapToBytes(dto.getPhoto()),
                dto.getDescription(),
                LocalDateTime.now(),
                dto.getCameraParameters(),
                dto.getLocation()
        );
    }

    private byte[] resizeAndMapToBytes(MultipartFile photo) throws IOException {
        BufferedImage buffered = ImageIO.read(photo.getInputStream());
        BufferedImage resized = Scalr.resize(buffered, TARGET_SIZE);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(resized, "png", byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    static LatestPhotoDto convertToLatestPhotoDto(Photo photo) {
        return new LatestPhotoDto(
                photo.get_id(),
                "data:image/png;base64," + Base64.getMimeEncoder().encodeToString(photo.getPhoto()),
                photo.getUploaded().toString("dd-MM-yyyy hh:mm:ss"),
                photo.getTitle(),
                photo.getDescription(),
                photo.getOwnerUsername(),
                photo.getCameraParameters(),
                photo.getLocation()
        );
    }
}
