package org.example.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ServletComponentScan
@EnableJpaAuditing
public class SpringBootWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootWebApplication.class, args);
  }

}
