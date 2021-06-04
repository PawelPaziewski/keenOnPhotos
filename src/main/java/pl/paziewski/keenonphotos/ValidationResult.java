package pl.paziewski.keenonphotos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ValidationResult {
    private final boolean valid;
    private final List<String> messages;
}

