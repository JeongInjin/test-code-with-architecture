package com.me.injin.testcodewithwitharchitecture.post.service.port;

import com.me.injin.testcodewithwitharchitecture.post.domain.Post;

import java.util.Optional;

public interface PostRepository {
    Optional<Post> findById(long id);

    Post save(Post post);
}
