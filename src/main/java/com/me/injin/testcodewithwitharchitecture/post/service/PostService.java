package com.me.injin.testcodewithwitharchitecture.post.service;


import java.time.Clock;

import com.me.injin.testcodewithwitharchitecture.common.domain.exception.ResourceNotFoundException;
import com.me.injin.testcodewithwitharchitecture.post.domain.PostCreate;
import com.me.injin.testcodewithwitharchitecture.post.domain.PostUpdate;
import com.me.injin.testcodewithwitharchitecture.post.infrastructure.PostEntity;
import com.me.injin.testcodewithwitharchitecture.post.service.port.PostRepository;
import com.me.injin.testcodewithwitharchitecture.user.infrastructure.UserEntity;
import com.me.injin.testcodewithwitharchitecture.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public PostEntity getById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Posts", id));
    }

    public PostEntity create(PostCreate postCreate) {
        UserEntity userEntity = userService.getById(postCreate.getWriterId());
        PostEntity postEntity = new PostEntity();
        postEntity.setWriter(userEntity);
        postEntity.setContent(postCreate.getContent());
        postEntity.setCreatedAt(Clock.systemUTC().millis());
        return postRepository.save(postEntity);
    }

    public PostEntity update(long id, PostUpdate postUpdate) {
        PostEntity postEntity = getById(id);
        postEntity.setContent(postUpdate.getContent());
        postEntity.setModifiedAt(Clock.systemUTC().millis());
        return postRepository.save(postEntity);
    }
}