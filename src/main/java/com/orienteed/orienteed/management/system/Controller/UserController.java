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
        boolean validPassword= false;
        Pattern passwordPattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{13,}$");
        Matcher passwordMatcher =passwordPattern.matcher(user.getUserPassword());
        validPassword = passwordMatcher.find();
    //Role validation
        boolean validRole= false;
        Pattern rolePattern = Pattern.compile("^(admin|project manager|consultant)$\n");
        Matcher roleMatcher =rolePattern.matcher(user.getRole());
        validRole = roleMatcher.find();
//    if(!validEmail || !validUsername || !validPassword || !validRole){
//        System.err.print("invalid input!!!");
//        return;
//    }
//    else {
//        System.out.print("valid input!!!");
//
//        userService.addUser(user);
//    }

        userService.addUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verify(user);
    }

    @RequestMapping("users")
    public List<User> getUsers() {
        return userService.getUsers();

    }


}
