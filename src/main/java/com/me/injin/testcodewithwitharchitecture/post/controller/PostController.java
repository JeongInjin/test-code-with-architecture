package com.me.injin.testcodewithwitharchitecture.post.controller;

import com.me.injin.testcodewithwitharchitecture.post.controller.response.PostResponse;
import com.me.injin.testcodewithwitharchitecture.post.domain.PostUpdate;
import com.me.injin.testcodewithwitharchitecture.post.service.PostServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "게시물(posts)")
@RestController
@RequestMapping("/api/posts")
@Builder
@RequiredArgsConstructor
public class PostController {

    private final PostServiceImpl postService;

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getById(@PathVariable long id) {
        return ResponseEntity
                .ok()
                .body(PostResponse.from(postService.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> update(@PathVariable long id, @RequestBody PostUpdate postUpdate) {
        return ResponseEntity
                .ok()
                .body(PostResponse.from(postService.update(id, postUpdate)));
    }
}