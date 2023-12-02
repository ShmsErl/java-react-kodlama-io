package com.example.javareactkamp.controller;

import com.example.javareactkamp.dto.userdto.request.AddUserRequest;
import com.example.javareactkamp.dto.userdto.request.UpdateUserRequest;
import com.example.javareactkamp.dto.userdto.response.GetAllUserResponse;
import com.example.javareactkamp.dto.userdto.response.GetUserResponse;
import com.example.javareactkamp.service.abstracts.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
@AllArgsConstructor
public class UserController {

    public final  UserService userService;

    @GetMapping(value = "/getall")
    public ResponseEntity<List<GetAllUserResponse>> getAllUsers(){

        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping(value = "/getbyemail")
    public ResponseEntity<GetUserResponse> getAllUsers(@Valid String email){

        return ResponseEntity.ok(this.userService.findByemail(email));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> addUser( @RequestBody @Valid AddUserRequest request){

        return new ResponseEntity<>(this.userService.addUser(request), HttpStatus.OK);
    }

    @PostMapping(value = "/put")
    public ResponseEntity<String> putUser(@Valid @RequestBody UpdateUserRequest request){

        return new ResponseEntity<>(this.userService.updateUser(request), HttpStatus.OK);
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> deleteUser(int id){


        return  new ResponseEntity<>(this.userService.deleteUser(id),HttpStatus.NO_CONTENT);
    }
}
