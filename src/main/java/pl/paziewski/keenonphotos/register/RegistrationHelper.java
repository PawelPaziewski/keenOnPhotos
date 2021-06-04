package pl.paziewski.keenonphotos.register;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.paziewski.keenonphotos.security.User;
import pl.paziewski.keenonphotos.security.UserRepository;

@AllArgsConstructor
class RegistrationHelper {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    boolean isLoginFree(String username) {
        return repository.findByUsername(username) == null;
    }

    User mapDtoToUser(RegisterDto dto) {
        return new User(dto.getUsername(), encoder.encode(dto.getPassword()), dto.getMail());
    }
}
