package pl.paziewski.keenonphotos.register;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
class ValidationResult {
    private final boolean valid;
    private final List<String> messages;
}

