package com.me.injin.testcodewithwitharchitecture.service;


import java.time.Clock;

import com.me.injin.testcodewithwitharchitecture.exception.ResourceNotFoundException;
import com.me.injin.testcodewithwitharchitecture.model.dto.PostCreateDto;
import com.me.injin.testcodewithwitharchitecture.model.dto.PostUpdateDto;
import com.me.injin.testcodewithwitharchitecture.repository.PostEntity;
import com.me.injin.testcodewithwitharchitecture.repository.PostRepository;
import com.me.injin.testcodewithwitharchitecture.repository.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public PostEntity getPostById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Posts", id));
    }

    public PostEntity createPost(PostCreateDto postCreateDto) {
        UserEntity userEntity = userService.getByIdOrElseThrow(postCreateDto.getWriterId());
        PostEntity postEntity = new PostEntity();
        postEntity.setWriter(userEntity);
        postEntity.setContent(postCreateDto.getContent());
        postEntity.setCreatedAt(Clock.systemUTC().millis());
        return postRepository.save(postEntity);
    }

    public PostEntity updatePost(long id, PostUpdateDto postUpdateDto) {
        PostEntity postEntity = getPostById(id);
        postEntity.setContent(postUpdateDto.getContent());
        postEntity.setModifiedAt(Clock.systemUTC().millis());
        return postRepository.save(postEntity);
    }
}