package lv.javaguru.java3OnlineBanking.core.services.clients;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.CoreValidationError;
import lv.javaguru.java3OnlineBanking.core.services.clients.validators.LoginValidator;
import lv.javaguru.java3OnlineBanking.core.services.clients.validators.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lv.javaguru.java3OnlineBanking.core.api.exceptions.builders.CoreValidationExceptionBuilder.createCoreValidationException;


public interface ClientValidator {
    void validate(String login, String password);
}

@Component
class ClientValidatorImpl implements ClientValidator {

    @Autowired
    private LoginValidator loginValidator;
    @Autowired
    private PasswordValidator passwordValidator;

    @Override
    public void validate(String login, String password) {

        List<CoreValidationError> errors = new ArrayList<>();
        errors.addAll(loginValidator.validate(login));
        errors.addAll(passwordValidator.validate(password));

        if (!errors.isEmpty()) {
            throw createCoreValidationException()
                    .withStatus(HttpStatus.BAD_REQUEST)
                    .withMessage("Validation failed!")
                    .withValidationErrors(errors)
                    .build();
        }
    }
}
