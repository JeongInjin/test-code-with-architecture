package com.me.injin.testcodewithwitharchitecture.post.controller.port;

import com.me.injin.testcodewithwitharchitecture.post.domain.Post;
import com.me.injin.testcodewithwitharchitecture.post.domain.PostCreate;
import com.me.injin.testcodewithwitharchitecture.post.domain.PostUpdate;

public interface PostService {
    Post getById(long id);

    Post create(PostCreate postCreate);

    Post update(long id, PostUpdate postUpdate);
}
