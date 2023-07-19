package com.me.injin.testcodewithwitharchitecture.user.service.port;

import com.me.injin.testcodewithwitharchitecture.user.domain.UserStatus;
import com.me.injin.testcodewithwitharchitecture.user.infrastructure.UserEntity;

import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> findById(long id);

    Optional<UserEntity> findByIdAndStatus(long id, UserStatus userStatus);

    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus userStatus);

    UserEntity save(UserEntity userEntity);

}
