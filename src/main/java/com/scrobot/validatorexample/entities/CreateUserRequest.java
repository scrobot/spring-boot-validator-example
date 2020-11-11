package com.scrobot.validatorexample.entities;

import com.scrobot.validatorexample.validators.constraits.AgeConstraint;
import com.scrobot.validatorexample.validators.constraits.LengthConstraint;
import com.scrobot.validatorexample.validators.constraits.PasswordConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Aleksei Scrobot
 */
@Data
@AllArgsConstructor
public class CreateUserRequest {

  private final String name;
  private final String email;

  @PasswordConstraint(message = "{user.password.regexp}")
  @LengthConstraint(message = "{user.password.size}")
  private final String password;

  @AgeConstraint(message = "{user.age}")
  private final int age;

}
