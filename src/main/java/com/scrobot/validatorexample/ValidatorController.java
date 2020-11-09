package com.scrobot.validatorexample;

import com.scrobot.validatorexample.entities.CreateUserRequest;
import com.scrobot.validatorexample.entities.User;
import com.scrobot.validatorexample.services.ValidationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author Aleksei Scrobot
 */
@RestController
@RequiredArgsConstructor
public class ValidatorController {

  private final ValidationService validationService;
  
  @PostMapping("api/user")
  public User createUser(@RequestBody CreateUserRequest request) {
      return validationService.create(
          request.getName(),
          request.getEmail(),
          request.getPassword(),
          request.getAge()
      );
  }

}
