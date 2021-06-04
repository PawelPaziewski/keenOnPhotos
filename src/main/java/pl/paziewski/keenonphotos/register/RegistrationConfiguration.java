package pl.paziewski.keenonphotos.register;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.paziewski.keenonphotos.security.UserRepository;

@Configuration
@AllArgsConstructor
class RegistrationConfiguration {

    final PasswordEncoder encoder;
    final UserRepository repository;

    @Bean
    RegistrationFacade getUserFacade() {
        RegistrationHelper helper = new RegistrationHelper(repository, encoder);
        return new RegistrationFacade(new RegistrationValidator(helper), repository, helper);
    }

}
