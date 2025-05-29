package com.orienteed.orienteed.management.system.Service;

import com.orienteed.orienteed.management.system.Model.User;
import com.orienteed.orienteed.management.system.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userService {


    @Autowired
    userRepo userrepo;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTService jwtService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public List<User> login() {

        return userrepo.findAll();
    }

    public void addUser(User user) {
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        userrepo.save(user);
    }

    public List<User> getUsers() {

        return userrepo.findAll();
    }

    public String verify(User user) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getUserPassword()));

        if(auth.isAuthenticated()){
            return jwtService.generateTokent(user.getUserName());
        }
            return "failed";

    }

    public boolean isProjectMangerUser(int userId) {

        User user = userrepo.findById(userId).orElseThrow(()-> new RuntimeException("user not found"));
        return user.getRole().equals("project manager");
    }
}
