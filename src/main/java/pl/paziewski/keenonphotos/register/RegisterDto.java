package pl.paziewski.keenonphotos.register;

import lombok.Getter;
import lombok.Setter;
import pl.paziewski.keenonphotos.security.User;

@Setter
@Getter
class RegisterDto {
    private String username = "";
    private String password = "";
    private String passwordRepeat = "";
    private String mail = "";

    void clearPassword() {
        password = "";
        passwordRepeat = "";
    }
}
