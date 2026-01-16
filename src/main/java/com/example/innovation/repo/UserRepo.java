package com.example.innovation.repo;

import com.example.innovation.models.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,Integer> {
    Optional<UserInfo> findByUsername(String username);
}
