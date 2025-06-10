package com.codewithmosh.store.controller;

import com.codewithmosh.store.dto.UserDto;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.mappers.UserMapper;
import com.codewithmosh.store.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @GetMapping
    public Iterable<UserDto> getAllUser(
            @RequestParam String sort
    ){

        if (!Set.of("name","email").contains(sort)){
            sort = "name";
        }

        return userRepository.findAll(Sort.by(sort).ascending())
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
