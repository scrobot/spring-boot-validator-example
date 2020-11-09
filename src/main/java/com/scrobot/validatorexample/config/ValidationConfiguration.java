package com.scrobot.validatorexample.config;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aleksei Scrobot
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("validation")
@NoArgsConstructor
@Getter
@Setter
@Data
public class ValidationConfiguration {

  private String password;
  private Integer minAge;

}
