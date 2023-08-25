package com.example.makeyourtrip.Services;

import com.example.makeyourtrip.Models.User;
import com.example.makeyourtrip.Repositories.UserRepository;
import com.example.makeyourtrip.RequestDto.AddUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String addUser(AddUserDto addUserDto){

        User user =  User.builder().age(addUserDto.getAge())
                .name(addUserDto.getName())
                .emailId(addUserDto.getEmailId())
                .build();

        userRepository.save(user);
        return "User has been saved successfully";

    }

}
