package com.me.injin.testcodewithwitharchitecture.repository;

import java.util.Optional;

import com.me.injin.testcodewithwitharchitecture.model.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByIdAndStatus(long id, UserStatus userStatus);

    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus userStatus);
}
