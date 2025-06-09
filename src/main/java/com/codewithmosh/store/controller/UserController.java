package com.codewithmosh.store.controller;

import com.codewithmosh.store.dto.UserDto;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.mappers.UserMapper;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @GetMapping
    public Iterable<UserDto> getAllUser(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable long id){
        var user = userRepository.findById(id).orElse(null);

        if (user == null){
//          return  ResponseEntity<User>(HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build();
        }

//        var userDto = new UserDto(user.getId(),user.getName(),user.getEmail());
//        return new ResponseEntity<>(user,HttpStatus.OK);
        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
