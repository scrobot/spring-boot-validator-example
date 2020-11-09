package com.scrobot.validatorexample.entities;

import com.scrobot.validatorexample.validators.constraits.AgeConstraint;
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
  @PasswordConstraint
  private final String password;
  @AgeConstraint
  private final int age;

}
