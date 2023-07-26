package com.me.injin.testcodewithwitharchitecture.post.service;


import com.me.injin.testcodewithwitharchitecture.common.domain.exception.ResourceNotFoundException;
import com.me.injin.testcodewithwitharchitecture.common.service.port.ClockHolder;
import com.me.injin.testcodewithwitharchitecture.post.controller.port.PostService;
import com.me.injin.testcodewithwitharchitecture.post.domain.Post;
import com.me.injin.testcodewithwitharchitecture.post.domain.PostCreate;
import com.me.injin.testcodewithwitharchitecture.post.domain.PostUpdate;
import com.me.injin.testcodewithwitharchitecture.post.service.port.PostRepository;
import com.me.injin.testcodewithwitharchitecture.user.domain.User;
import com.me.injin.testcodewithwitharchitecture.user.service.port.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ClockHolder clockHolder;

    public Post getById(long id) {
        return postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Posts", id));
    }

    public Post create(PostCreate postCreate) {
        User writer = userRepository.getById(postCreate.getWriterId());
        Post postEntity = Post.from(writer, postCreate, clockHolder);
        return postRepository.save(postEntity);
    }

    public Post update(long id, PostUpdate postUpdate) {
        Post post = getById(id);
        post = post.update(postUpdate, clockHolder);
        return postRepository.save(post);
    }
}