package com.me.injin.testcodewithwitharchitecture.user.controller.port;

import com.me.injin.testcodewithwitharchitecture.user.domain.User;
import com.me.injin.testcodewithwitharchitecture.user.domain.UserCreate;
import com.me.injin.testcodewithwitharchitecture.user.domain.UserUpdate;

public interface UserCreateService {
    User create(UserCreate userCreate);
}
