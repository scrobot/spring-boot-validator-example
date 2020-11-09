package com.scrobot.validatorexample.data;

import com.scrobot.validatorexample.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Aleksei Scrobot
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
