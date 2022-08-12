package com.example.advancelearningapp.controller.annotation;

import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.passay.EnglishCharacterData.*;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    public void initialize(ValidPassword arg0) {
    }


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Properties props = new Properties();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("passay.properties");

        try {
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        MessageResolver resolver = new PropertiesMessageResolver(props);
        Object EnglishCharacterData = null;
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                // at least 8 characters
                new LengthRule(8, 16),

                // at least one upper-case character
                new CharacterRule(UpperCase, 1),

                // at least one lower-case character
                new CharacterRule(LowerCase, 1),

                // at least one digit character
                new CharacterRule(Digit, 1),

                // at least one symbol (special character)
                new CharacterRule(Special, 1),

                // no whitespace
                new WhitespaceRule(),
        new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),

        // rejects passwords that contain a sequence of >= 5 characters numerical   (e.g. 12345)

        new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false)

        ));
        String password = null;
        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        List<String> messages = validator.getMessages(result);
       
        String messageTemplate = String.join(",", messages);

        ConstraintValidatorContext context = null;
        context.buildConstraintViolationWithTemplate(messageTemplate)
        
                .addConstraintViolation()
       
                .disableDefaultConstraintViolation();
        
        
        return false;
    }
}

