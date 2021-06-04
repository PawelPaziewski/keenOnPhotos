package pl.paziewski.keenonphotos.register;

import lombok.AllArgsConstructor;
import pl.paziewski.keenonphotos.security.User;
import pl.paziewski.keenonphotos.security.UserRepository;

import java.util.List;

@AllArgsConstructor
class RegistrationFacade {

    private final RegistrationValidator validator;
    private final UserRepository repository;
    private final RegistrationHelper helper;

    public ValidationResult addUser(RegisterDto dto) {
        List<String> messages = validator.validate(dto);
        if (messages.isEmpty()) {
            User user = helper.mapDtoToUser(dto);
            repository.save(user);
            messages.add("Successfully registered");
            dto.clearPassword();
            return new ValidationResult(true, messages);
        } else {
            dto.clearPassword();
            return new ValidationResult(false, messages);
        }
    }

}
