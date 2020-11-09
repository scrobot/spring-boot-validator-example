package com.scrobot.validatorexample.services;

import com.scrobot.validatorexample.entities.User;

/**
 * @author Aleksei Scrobot
 */
public interface ValidationService {

  User create(String name, String email, String password, int age);

}
