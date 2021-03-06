package com.brightest.study.springboot.web;

import com.brightest.study.springboot.service.posts.PostsService;
import com.brightest.study.springboot.web.dto.PostsResponseDto;
import com.brightest.study.springboot.web.dto.PostsSaveRequestDto;
import com.brightest.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor  // final로 선언된 필드를 생성자로 주입
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long postsDelete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
