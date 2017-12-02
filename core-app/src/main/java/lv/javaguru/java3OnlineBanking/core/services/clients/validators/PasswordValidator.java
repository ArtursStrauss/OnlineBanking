package lv.javaguru.java3OnlineBanking.core.services.clients.validators;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.CoreValidationError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;
import static lv.javaguru.java3OnlineBanking.core.api.exceptions.builders.CoreValidationErrorBuilder.createCoreValidationError;

public interface PasswordValidator {
    List<CoreValidationError> validate(String password);
}

@Component
class PasswordValidatorImpl implements PasswordValidator {

    private static final int PASSWORD_MIN_LENGTH = 8;

    @Override
    public List<CoreValidationError> validate(String password) {
        List<CoreValidationError> errors = new ArrayList<>();

        if (isEmpty(password)) {
            errors.add(createCoreValidationError()
                    .withField("password")
                    .withErrorCode("empty.field")
                    .withDescription("Password must not be empty!")
                    .build());
        } else {
            minLength(password).ifPresent(errors::add);
        }
        return errors;
    }

    private boolean isEmpty(String password) {
        try {
            checkNotNull(password);
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private Optional<CoreValidationError> minLength(String password) {
        if (password.length() < PASSWORD_MIN_LENGTH) {
            return Optional.of(createCoreValidationError()
                    .withField("password")
                    .withErrorCode("invalid.value")
                    .withDescription("Min length must be at least 8 characters")
                    .build());
        }
        return Optional.empty();
    }
}