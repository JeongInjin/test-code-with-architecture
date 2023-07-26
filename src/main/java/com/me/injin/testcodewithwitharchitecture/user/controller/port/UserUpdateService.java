package com.me.injin.testcodewithwitharchitecture.user.controller.port;

import com.me.injin.testcodewithwitharchitecture.user.domain.User;
import com.me.injin.testcodewithwitharchitecture.user.domain.UserUpdate;

public interface UserUpdateService {
    User update(long id, UserUpdate userUpdate);
}
