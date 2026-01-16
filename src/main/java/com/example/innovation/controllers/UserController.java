package com.example.innovation.controllers;

import com.example.innovation.dto.UserReqDto;
import com.example.innovation.models.UserInfo;
import com.example.innovation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserReqDto userReqDto) {
        UserInfo userInfo=userService.addUser(userReqDto);

        URI uri=URI.create("/api/v1/user/id="+userInfo.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> findById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(userService.findUserById(id));
    }
}
