package org.example.springbootweb.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.springbootweb.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "body请求", description = "body请求")
public class BodyController {
    @Operation(summary = "普通body请求", description = "输入user返回user信息")
    @PostMapping("/body")
    public ResponseEntity<User> body(@RequestBody User user) {
      return ResponseEntity.ok(user);
    }

    @Operation(summary = "带参数body请求", description = "输入id, name, token, user返回user信息")
    @Parameters({
        @Parameter(name = "id", description = "用户ID", in = ParameterIn.PATH),
        @Parameter(name = "name", description = "用户名称", in = ParameterIn.QUERY),
        @Parameter(name = "token", description = "用户token", in = ParameterIn.HEADER),
    })
    @PostMapping("/bodyParamHeaderPath/{id}")
    public ResponseEntity<User> bodyParamHeaderPath(@PathVariable("id") String id, @RequestParam("name") String name, @RequestHeader("token") String token, @RequestBody User user) {
      user.setName(user.getName() + ", receiveName:" + name + ", receiveId:" + id + ", receiveToken:" + token);
      return ResponseEntity.ok(user);
    }

}
