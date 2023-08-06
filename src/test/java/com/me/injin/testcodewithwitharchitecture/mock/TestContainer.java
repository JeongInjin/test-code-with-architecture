package com.me.injin.testcodewithwitharchitecture.mock;

import com.me.injin.testcodewithwitharchitecture.common.service.port.ClockHolder;
import com.me.injin.testcodewithwitharchitecture.common.service.port.UuidHolder;
import com.me.injin.testcodewithwitharchitecture.post.controller.PostController;
import com.me.injin.testcodewithwitharchitecture.post.controller.PostCreateController;
import com.me.injin.testcodewithwitharchitecture.post.service.PostServiceImpl;
import com.me.injin.testcodewithwitharchitecture.post.service.port.PostRepository;
import com.me.injin.testcodewithwitharchitecture.user.controller.UserController;
import com.me.injin.testcodewithwitharchitecture.user.controller.UserCreateController;
import com.me.injin.testcodewithwitharchitecture.user.controller.port.AuthenticationService;
import com.me.injin.testcodewithwitharchitecture.user.controller.port.UserCreateService;
import com.me.injin.testcodewithwitharchitecture.user.controller.port.UserUpdateService;
import com.me.injin.testcodewithwitharchitecture.user.service.CertificationService;
import com.me.injin.testcodewithwitharchitecture.user.service.UserServiceImpl;
import com.me.injin.testcodewithwitharchitecture.user.service.port.MailSender;
import com.me.injin.testcodewithwitharchitecture.user.service.port.UserRepository;
import lombok.Builder;

public class TestContainer {

    public final MailSender mailSender;
    public final UserRepository userRepository;
    public final PostRepository postRepository;
    public final PostServiceImpl postService;
    public final CertificationService certificationService;
    public final UserController userController;
    public final UserCreateController userCreateController;
    public final PostController postController;
    public final PostCreateController postCreateController;

    @Builder
    public TestContainer(ClockHolder clockHolder, UuidHolder uuidHolder) {
        this.mailSender = new FakeMailSender();
        this.userRepository = new FakeUserRepository();
        this.postRepository = new FakePostRepository();
        this.postService = PostServiceImpl.builder()
                .postRepository(this.postRepository)
                .userRepository(this.userRepository)
                .clockHolder(clockHolder)
                .build();
        this.certificationService = new CertificationService(this.mailSender);
        UserServiceImpl userService = UserServiceImpl.builder()
                .uuidHolder(uuidHolder)
                .clockHolder(clockHolder)
                .userRepository(this.userRepository)
                .certificationService(this.certificationService)
                .build();
        this.userController = UserController.builder()
                .userService(userService)
                .build();
        this.userCreateController = UserCreateController.builder()
                .userService(userService)
                .build();
        this.postController = PostController.builder()
                .postService(postService)
                .build();
        this.postCreateController = PostCreateController.builder()
                .postService(postService)
                .build();
    }
}
