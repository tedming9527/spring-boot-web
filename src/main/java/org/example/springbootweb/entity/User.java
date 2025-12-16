package org.example.springbootweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
  private Integer id;
  @NotBlank(message = "name不能为空")
  private String name;
  @Min(value = 0, message = "age不能小于0")
  private Integer age;
  @Email(message = "email格式不正确")
  private String email;
  @NotNull(message = "birthday不能为空")
  @Past(message = "birthday必须是过去的时间")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthday;
}
