package org.example.springbootweb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.springbootweb.dao.UserRepository;
import org.example.springbootweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "用户接口", description = "用户接口")
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @Operation(summary = "根据 id 获取用户")
  @GetMapping("/{id}")
  private User get(@PathVariable Long id) {
    return userRepository.findById(id).orElseThrow(() -> new RuntimeException("用户不存在"));
  }
  @Operation(summary = "创建用户")
  @PostMapping
  public User create(@Valid @RequestBody User user) {
    return userRepository.save(user);
  }

  @Operation(summary = "更新用户")
  @PutMapping
  public User update(@Valid @RequestBody User user) {
    return userRepository.save(user);
  }
  @Operation(summary = "删除用户")
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    userRepository.deleteById(id);
  }
  public Page<User> list(
    @RequestParam(defaultValue = "id") String property,
    @RequestParam(defaultValue = "ASC") Sort.Direction direction,
    @RequestParam(defaultValue = "0") int page,
    @RequestParam(defaultValue = "10") int size
  ) {
    Pageable pageable = PageRequest.of(page, size, direction, property);
    return userRepository.findAll(pageable);
  }
  @Operation(summary = "根据 name 获取用户")
  @GetMapping("/name")
  public List<User> getByName(String name) {
    return userRepository.findByNameContaining(name);
  }

  @Operation(summary = "根据 birthday 获取用户")
  @GetMapping("/birthday")
  public List<User> getByBirthday(@RequestParam LocalDate birthday) {
    return userRepository.findByBirthday(birthday);
  }
  @Operation(summary = "根据 birthday 获取用户")
  @GetMapping("/birthday/native")
  public List<User> getByBirthdayNative(@RequestParam String birthday) {
    return userRepository.findByBirthdayNative(birthday);
  }
}
