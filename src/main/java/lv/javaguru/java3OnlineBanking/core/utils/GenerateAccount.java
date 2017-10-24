package lv.javaguru.java3OnlineBanking.core.utils;

import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

import static org.apache.commons.text.CharacterPredicates.DIGITS;
import static org.apache.commons.text.CharacterPredicates.LETTERS;

@Component
public class GenerateAccount {

    private static final int ACCOUNT_LENGTH = 20;

    public String generateAccount(){
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0','Z')
                .filteredBy(LETTERS, DIGITS)
                .build();
        return generator.generate(ACCOUNT_LENGTH);
    }
}
