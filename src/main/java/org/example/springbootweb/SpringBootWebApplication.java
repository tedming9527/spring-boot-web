package org.example.springbootweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.servlet.context.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("org.example.springbootweb.mbp.mapper")
public class SpringBootWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootWebApplication.class, args);
  }

}
