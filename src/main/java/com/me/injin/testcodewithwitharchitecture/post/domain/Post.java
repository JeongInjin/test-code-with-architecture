package com.me.injin.testcodewithwitharchitecture.post.domain;

import com.me.injin.testcodewithwitharchitecture.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Post {

    private final Long id;
    private final String content;
    private final Long createdAt;
    private final Long modifiedAt;
    private final User writer;

    @Builder
    public Post(Long id, String content, Long createdAt, Long modifiedAt, User writer) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.writer = writer;
    }
}
