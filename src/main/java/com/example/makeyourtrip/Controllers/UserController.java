package com.example.makeyourtrip.Controllers;

import com.example.makeyourtrip.RequestDto.AddUserDto;
import com.example.makeyourtrip.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody AddUserDto addUserDto){

        return userService.addUser(addUserDto);
    }
}
