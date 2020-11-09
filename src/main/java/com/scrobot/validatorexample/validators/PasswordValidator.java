package com.scrobot.validatorexample.validators;

import com.scrobot.validatorexample.config.ValidationConfiguration;
import com.scrobot.validatorexample.utils.BeanUtil;
import com.scrobot.validatorexample.validators.constraits.PasswordConstraint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowire;
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
public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {

  private ValidationConfiguration configuration;

  @Override
  public void initialize(PasswordConstraint constraintAnnotation) {
    configuration = BeanUtil.getBean(ValidationConfiguration.class);
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    Pattern pattern = Pattern.compile(configuration.getPassword());
    Matcher matcher = pattern.matcher(value);
    try {
      if (!matcher.matches()) {
        return false;
      } else {
        return true;
      }
    } catch (Exception e) {
      return false;
    }
  }

}
