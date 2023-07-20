package com.me.injin.testcodewithwitharchitecture.post.controller.response;

import com.me.injin.testcodewithwitharchitecture.post.domain.Post;
import com.me.injin.testcodewithwitharchitecture.user.domain.User;
import com.me.injin.testcodewithwitharchitecture.user.domain.UserStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PostResponseTest {

    @Test
    public void Post로_응답을_생성할_수_있다() throws Exception {
        // given
        Post post = Post.builder()
                .content("helloworld")
                .writer(User.builder()
                        .email("injin.dev@gmail.com")
                        .nickname("injin")
                        .address("Seoul")
                        .status(UserStatus.ACTIVE)
                        .certificationCode("aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaab")
                        .build())
                .build();

        // when
        PostResponse postResponse = PostResponse.from(post);

        // then
        assertThat(postResponse.getContent()).isEqualTo("helloworld");
        assertThat(postResponse.getWriter().getEmail()).isEqualTo("injin.dev@gmail.com");
        assertThat(postResponse.getWriter().getNickname()).isEqualTo("injin");
        assertThat(postResponse.getWriter().getStatus()).isEqualTo(UserStatus.ACTIVE);
    }

}