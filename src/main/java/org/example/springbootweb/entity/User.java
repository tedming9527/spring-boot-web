package org.example.springbootweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class User {
  private Integer id;
  @NotBlank(message = "name 不能为空")
  private String name;
  @Pattern(regexp = "^(male|female)$", message = "性别值只能是 male 或者 female")
  private String gender;
  @Min(value = 0, message = "age 不能小于 0")
  private Integer age;
  @Email(message = "email 格式不正确")
  private String email;
  @NotNull(message = "birthday 不能为空")
  @Past(message = "birthday 必须是过去的时间")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthday;
}
