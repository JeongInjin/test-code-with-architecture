package com.me.injin.testcodewithwitharchitecture.post.controller;

import com.me.injin.testcodewithwitharchitecture.post.domain.PostCreate;
import com.me.injin.testcodewithwitharchitecture.post.controller.response.PostResponse;
import com.me.injin.testcodewithwitharchitecture.post.service.PostServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "게시물(posts)")
@RestController
@RequestMapping("/api/posts")
@Builder
@RequiredArgsConstructor
public class PostCreateController {

    private final PostServiceImpl postService;
    private final PostController postController;

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostCreate postCreate) {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(PostResponse.from(postService.create(postCreate)));
    }
}