package com.me.injin.testcodewithwitharchitecture.user.controller;

import com.me.injin.testcodewithwitharchitecture.mock.TestContainer;
import com.me.injin.testcodewithwitharchitecture.user.controller.response.UserResponse;
import com.me.injin.testcodewithwitharchitecture.user.domain.UserCreate;
import com.me.injin.testcodewithwitharchitecture.user.domain.UserStatus;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class UserCreateControllerTest {

    @Test
    void 사용자는_회원_가입을_할_수있고_회원가입된_사용자는_PENDING_상태이다() throws Exception {
        // given
        TestContainer testContainer = TestContainer.builder()
                .uuidHolder(() -> "aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaab")
                .build();
        UserCreate userCreate = UserCreate.builder()
                .email("injin.dev@gmail.com")
                .nickname("injin")
                .address("Pangyo")
                .build();

        // when
        ResponseEntity<UserResponse> result = testContainer.userCreateController.create(userCreate);

        // then
        assertThat(result.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getEmail()).isEqualTo("injin.dev@gmail.com");
        assertThat(result.getBody().getNickname()).isEqualTo("injin");
        assertThat(result.getBody().getLastLoginAt()).isNull();
        assertThat(result.getBody().getStatus()).isEqualTo(UserStatus.PENDING);
        assertThat(testContainer.userRepository.getById(1).getCertificationCode()).isEqualTo("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaab");
    }
}
