package com.me.injin.testcodewithwitharchitecture.user.controller.port;

import com.me.injin.testcodewithwitharchitecture.user.domain.User;
import com.me.injin.testcodewithwitharchitecture.user.domain.UserCreate;
import com.me.injin.testcodewithwitharchitecture.user.domain.UserUpdate;

public interface UserReadService {
    User getByEmail(String email);

    User getById(long id);
}
