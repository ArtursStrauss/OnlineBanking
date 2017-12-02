package lv.javaguru.java3OnlineBanking.core.services.clients.validators;

import lv.javaguru.java3OnlineBanking.core.api.exceptions.CoreValidationError;
import lv.javaguru.java3OnlineBanking.core.domain.Client;
import lv.javaguru.java3OnlineBanking.core.domain.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;
import static lv.javaguru.java3OnlineBanking.core.api.exceptions.builders.CoreValidationErrorBuilder.createCoreValidationError;

public interface LoginValidator {
    List<CoreValidationError> validate(String login);
}

@Component
class LoginValidatorImpl implements LoginValidator {

    private static final int LOGIN_MIN_LENGTH = 5;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<CoreValidationError> validate(String login) {
        List<CoreValidationError> errors = new ArrayList<>();

        if (isEmpty(login)) {
            errors.add(createCoreValidationError()
                    .withField("login")
                    .withErrorCode("empty.field")
                    .withDescription("Client login must not be empty!")
                    .build());
        } else {
            minLength(login).ifPresent(errors::add);
            isUnique(login).ifPresent(errors::add);
        }
        return errors;

    }

    private boolean isEmpty(String login) {
        try {
            checkNotNull(login);
        } catch (IllegalArgumentException e) {
            return true;
        }
        return false;
    }

    private Optional<CoreValidationError> minLength(String login) {
        if (login.length() < LOGIN_MIN_LENGTH) {
            return Optional.of(createCoreValidationError()
                    .withField("login")
                    .withErrorCode("invalid.value")
                    .withDescription("Min length must be at least 5 characters")
                    .build());
        }
        return Optional.empty();
    }

    private Optional<CoreValidationError> isUnique(String login) {

        Optional<Client> existingClient = clientRepository.findOneByLogin(login);

        if (existingClient.isPresent()) {
            return Optional.of(createCoreValidationError()
                    .withField("login")
                    .withErrorCode("invalid.value")
                    .withDescription("Client with login already exist")
                    .build());
        }
        return Optional.empty();
    }
}