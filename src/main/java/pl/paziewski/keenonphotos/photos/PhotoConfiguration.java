package pl.paziewski.keenonphotos.photos;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class PhotoConfiguration {

    private final PhotoRepository repository;

    @Bean
    PhotoFacade getPhotoFacade() {
        return new PhotoFacade(new PhotoValidator(), repository, new PhotoHelper());
    }
}
