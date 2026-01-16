package com.example.innovation.implementation;

import com.example.innovation.dto.UserReqDto;
import com.example.innovation.models.UserInfo;
import com.example.innovation.repo.UserRepo;
import com.example.innovation.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@Service
public class UserImplementation implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserInfo addUser(UserReqDto userReqDto) {
        UserInfo userInfo = new UserInfo();

        userInfo.setFirstName(userReqDto.getFirstName());
        userInfo.setLastName(userReqDto.getLastName());
        userInfo.setUsername(userReqDto.getUsername());
        userInfo.setPassword(passwordEncoder.encode(userReqDto.getPassword()));
        userInfo.setRoles(userReqDto.getRoles());
        return userRepo.save(userInfo);

    }

    @Override
    public UserInfo findUserById(Integer id) {
        return userRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Invalid id"));
    }
}
