package com.me.injin.testcodewithwitharchitecture.post.controller.response;

import com.me.injin.testcodewithwitharchitecture.user.controller.response.UserResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponse {

    private Long id;
    private String content;
    private Long createdAt;
    private Long modifiedAt;
    private UserResponse writer;
}
