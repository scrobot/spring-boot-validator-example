package com.scrobot.validatorexample.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aleksei Scrobot
 */
@RefreshScope
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("validation")
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Data
public class ValidationConfiguration {

  private String password;
  private Integer minAge;
  private Length length;

  @NoArgsConstructor
  @AllArgsConstructor
  @Accessors(chain = true)
  @Data
  public static class Length {

    private int min;
    private int max;

  }

}
