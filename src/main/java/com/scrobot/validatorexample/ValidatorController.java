package com.scrobot.validatorexample;

import com.scrobot.validatorexample.entities.CreateUserRequest;
import com.scrobot.validatorexample.entities.User;
import com.scrobot.validatorexample.services.ValidationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


/**
 * @author Aleksei Scrobot
 */
@Tag(name = "validation", description = "creating users with validation")
@RestController
@RequiredArgsConstructor
public class ValidatorController {

  private final ValidationService validationService;

  @Operation(summary = "Creates new user", tags = "validation")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Successful operation"),
      @ApiResponse(responseCode = "400", description = "Bad request"),
      @ApiResponse(responseCode = "500", description = "Internal server error")
  })
  @PostMapping("api/user")
  public User createUser(@Valid @RequestBody CreateUserRequest request) {
      return validationService.create(
          request.getName(),
          request.getEmail(),
          request.getPassword(),
          request.getAge()
      );
  }

}
