package com.scrobot.validatorexample.validators.constraits;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.scrobot.validatorexample.validators.PasswordValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Aleksei Scrobot
 */
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface PasswordConstraint {

  String message() default "invalid password";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

}
