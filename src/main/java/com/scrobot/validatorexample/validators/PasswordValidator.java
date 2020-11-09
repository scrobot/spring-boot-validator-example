package com.scrobot.validatorexample.validators;

import com.scrobot.validatorexample.config.ValidationConfiguration;
import com.scrobot.validatorexample.utils.BeanUtil;
import com.scrobot.validatorexample.validators.constraits.PasswordConstraint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Aleksei Scrobot
 */
@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

  @Autowired
  private ValidationConfiguration configuration;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    Pattern pattern = Pattern.compile(configuration.getPassword());
    Matcher matcher = pattern.matcher(value);
    try {
      return matcher.matches();
    } catch (Exception e) {
      return false;
    }
  }

}
