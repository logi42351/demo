package com.example.innovation.config;

import com.example.innovation.models.UserInfo;
import com.example.innovation.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo=userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
        return new UserInfoDetails(userInfo);
    }

}
