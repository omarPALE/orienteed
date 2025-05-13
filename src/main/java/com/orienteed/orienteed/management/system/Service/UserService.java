package com.orienteed.orienteed.management.system.Service;

import com.orienteed.orienteed.management.system.Model.User;
import com.orienteed.orienteed.management.system.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    userRepo userrepo;

    public List<User> login() {

        return userrepo.findAll();
    }

    public void addUser(User user) {
        userrepo.save(user);
    }
}
