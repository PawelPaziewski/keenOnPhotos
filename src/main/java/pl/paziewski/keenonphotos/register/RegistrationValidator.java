package pl.paziewski.keenonphotos.register;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
class RegistrationValidator {

    RegistrationHelper registrationHelper;

    List<String> validate(RegisterDto dto) {
        List<String> loginErrors = validateLogin(dto);
        List<String> passwordErrors = validatePassword(dto);
        List<String> mailErrors = validateMail(dto);
        List<String> errors = new LinkedList<>();
        errors.addAll(loginErrors);
        errors.addAll(passwordErrors);
        errors.addAll(mailErrors);
        return errors;
    }

    private List<String> validateMail(RegisterDto dto) {
        List<String> errors = new LinkedList<>();
        if (!dto.getMail().matches("^(.+)@(.+)$")) {
            errors.add("Email should have email structure");
        }
        return errors;
    }

    private List<String> validateLogin(RegisterDto dto) {
        List<String> errors = new LinkedList<>();
        if (dto.getUsername().equals("")) {
            errors.add("Username may not be empty");
        } else if (!registrationHelper.isLoginFree(dto.getUsername())) {
            errors.add("Username is already used");
        }
        return errors;
    }

    private List<String> validatePassword(RegisterDto dto) {
        List<String> errors = new LinkedList<>();
        if (dto.getPassword().equals("")) {
            errors.add("Password should not be empty");
        } else if (!dto.getPassword().equals(dto.getPasswordRepeat())) {
            errors.add("Password and repeat password should be the same");
        }
        return errors;
    }
}
