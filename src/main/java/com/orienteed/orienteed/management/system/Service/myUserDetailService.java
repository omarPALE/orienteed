package com.orienteed.orienteed.management.system.Service;

import com.orienteed.orienteed.management.system.Model.User;
import com.orienteed.orienteed.management.system.Model.customUserDetails;
import com.orienteed.orienteed.management.system.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class myUserDetailService implements UserDetailsService {

    @Autowired
    userRepo userTable;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userTable.findByuserName(userName);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new customUserDetails(user);
    }
}
