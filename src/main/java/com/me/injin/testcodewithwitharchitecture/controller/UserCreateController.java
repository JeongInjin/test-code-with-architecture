package com.me.injin.testcodewithwitharchitecture.controller;


import com.me.injin.testcodewithwitharchitecture.model.dto.UserCreateDto;
import com.me.injin.testcodewithwitharchitecture.model.dto.UserResponse;
import com.me.injin.testcodewithwitharchitecture.repository.UserEntity;
import com.me.injin.testcodewithwitharchitecture.service.UserService;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저(users)")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserCreateController {

    private final UserController userController;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateDto userCreateDto) {
        UserEntity userEntity = userService.createUser(userCreateDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userController.toResponse(userEntity));
    }

}