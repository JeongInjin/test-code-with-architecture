package com.me.injin.testcodewithwitharchitecture.user.infrastructure;

import java.util.Optional;

import com.me.injin.testcodewithwitharchitecture.user.domain.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByIdAndStatus(long id, UserStatus userStatus);

    Optional<UserEntity> findByEmailAndStatus(String email, UserStatus userStatus);
}
