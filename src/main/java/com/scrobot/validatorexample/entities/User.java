package com.scrobot.validatorexample.entities;

import com.scrobot.validatorexample.validators.constraits.AgeConstraint;
import com.scrobot.validatorexample.validators.constraits.PasswordConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @author Aleksei Scrobot
 */
@Entity
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {

  @Id
  private long id;
  private String name;
  private String email;
  private String password;
  private int age;
}
