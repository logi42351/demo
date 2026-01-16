package com.example.innovation.service;

import com.example.innovation.dto.UserReqDto;
import com.example.innovation.models.UserInfo;

public interface UserService {

    UserInfo addUser(UserReqDto userReqDto);

    UserInfo findUserById(Integer id);
}
