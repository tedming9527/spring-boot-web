package org.example.springbootweb.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.springbootweb.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Tag(name = "订单接口", description = "订单接口")
public class OrderController {
  // 新的机遇 path_pattern_matcher 的匹配机制
  @GetMapping
  public String getOrders() {
    return "getOrders";
  }
  @GetMapping("/{id}")
  public  String get(@PathVariable Integer id) {
    return "get " + id;
  }

  @PostMapping
  public User save(@RequestBody @Valid User user) {
    return user;
  }
  @PutMapping
  public String update(@RequestBody User user) {
    return "update " + user.getId();
  }
  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    return "delete " + id;
  }
}
