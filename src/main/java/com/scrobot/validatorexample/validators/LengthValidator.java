package com.scrobot.validatorexample.validators;

import com.scrobot.validatorexample.config.ValidationConfiguration;
import com.scrobot.validatorexample.validators.constraits.AgeConstraint;
import com.scrobot.validatorexample.validators.constraits.LengthConstraint;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Aleksei Scrobot
 */
@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class LengthValidator implements ConstraintValidator<LengthConstraint, String> {

  @Autowired
  private ValidationConfiguration configuration;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value.length() >= configuration.getLength().getMin() && value.length() <= configuration.getLength().getMax();
  }

}
