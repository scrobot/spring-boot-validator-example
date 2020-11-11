package com.scrobot.validatorexample.services;

import com.scrobot.validatorexample.data.UserRepository;
import com.scrobot.validatorexample.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Aleksei Scrobot
 */
@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

  private final UserRepository repository;

  @Override
  public User create(String name, String email, String password, int age) {
    return repository.save(
        new User()
          .setAge(age)
          .setName(name)
          .setEmail(email)
          .setPassword(password)
    );
  }

}
