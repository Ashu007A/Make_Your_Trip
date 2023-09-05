package com.example.makeyourtrip.Controllers;

import com.example.makeyourtrip.RequestDTOs.AddUserDto;
import com.example.makeyourtrip.Services.BookingService;
import com.example.makeyourtrip.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add")
    public String addUser(@RequestBody AddUserDto addUserDto){

        return userService.addUser(addUserDto);
    }

    @GetMapping("/distinctUsersWithAtLeastTwoSeats")
    public ResponseEntity<Long> findDistinctUsersWithAtLeastTwoSeats() {
        long count = bookingService.findDistinctUsersWithAtLeastTwoSeatsInOneBooking();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

}
