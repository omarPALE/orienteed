package com.orienteed.orienteed.management.system.Controller;

import com.orienteed.orienteed.management.system.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orienteed.orienteed.management.system.Model.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public void addUser(@RequestBody User user) {
    //email validation
    boolean validEmail= false;
    Pattern pat= Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    Matcher match =pat.matcher(user.getUserEmail());
    validEmail = match.find();
    //userName validation
    boolean validUsername= false;
    Pattern userNamePattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    Matcher userNameMatcher =userNamePattern.matcher(user.getUserName());
    validUsername = userNameMatcher.find();
    //Password Validation


    userService.addUser(user);
    }

    @RequestMapping("users")
    public List<User> getUsers() {
        return userService.getUsers();

    }


}
