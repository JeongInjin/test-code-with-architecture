package com.me.injin.testcodewithwitharchitecture.user.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.me.injin.testcodewithwitharchitecture.user.domain.UserUpdate;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserUpdateRequest {
    private final String nickname;
    private final String address;

    @Builder
    public UserUpdateRequest(
            @JsonProperty("nickname") String nickname,
            @JsonProperty("address") String address) {
        this.nickname = nickname;
        this.address = address;
    }

    public UserUpdate to() {
        return new UserUpdate(nickname, address);
    }
}
