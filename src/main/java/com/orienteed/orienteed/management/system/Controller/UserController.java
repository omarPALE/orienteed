package com.orienteed.orienteed.management.system.Controller;

import com.orienteed.orienteed.management.system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.orienteed.orienteed.management.system.Model.User;
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public void addUser(@RequestBody User user) {
    userService.addUser(user);
    }


}
