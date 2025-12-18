package org.example.springbootweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(indexes = @Index(name="uk_email", columnList = "email", unique = true))
public class User extends BaseEntity{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank(message = "name 不能为空")
  @Column(nullable = false, columnDefinition = "varchar(20) comment '姓名'")
  private String name;
  @Column(nullable = false, columnDefinition = "varchar(20) comment '性别'")
  @NotNull(message = "gender 不能为空")
  @Pattern(regexp = "^(male|female)$", message = "性别值只能是 male 或者 female")
  private String gender;
  @Transient
  @Min(value = 0, message = "age 不能小于 0")
  private Integer age;
  @Column(nullable = false, columnDefinition = "varchar(50) comment '邮箱'")
  @Email(message = "email 格式不正确")
  private String email;
  @Column(nullable = false, columnDefinition = "Date comment '生日'")
  @NotNull(message = "birthday 不能为空")
  @Past(message = "birthday 必须是过去的时间")
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthday;
}
