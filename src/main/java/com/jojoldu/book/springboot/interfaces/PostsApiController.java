package com.jojoldu.book.springboot.interfaces;

import com.jojoldu.book.springboot.application.service.posts.PostsService;
import com.jojoldu.book.springboot.interfaces.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("api/v1/posts/{id}")
    public PostsResponseDto getFindById(@PathVariable Long id) {
        return postsService.excute(id);
    }

}
