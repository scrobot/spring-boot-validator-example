package com.scrobot.validatorexample.validators;

import com.scrobot.validatorexample.config.ValidationConfiguration;
import com.scrobot.validatorexample.utils.BeanUtil;
import com.scrobot.validatorexample.validators.constraits.AgeConstraint;
import com.scrobot.validatorexample.validators.constraits.PasswordConstraint;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Aleksei Scrobot
 */
@Configurable(autowire = Autowire.BY_TYPE, dependencyCheck = true)
public class AgeValidator implements ConstraintValidator<AgeConstraint, Number> {

  @Autowired
  private ValidationConfiguration configuration;

  @Override
  public boolean isValid(Number value, ConstraintValidatorContext context) {
    return value.intValue() >= configuration.getMinAge();
  }

}
