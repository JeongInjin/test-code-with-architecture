package com.me.injin.testcodewithwitharchitecture.post.service.port;

import com.me.injin.testcodewithwitharchitecture.post.infrastructure.PostEntity;

import java.util.Optional;

public interface PostRepository {
    Optional<PostEntity> findById(long id);

    PostEntity save(PostEntity postEntity);
}
