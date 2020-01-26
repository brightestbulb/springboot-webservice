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

    @PutMapping("/api/v1/posts/{bno}")
    public Long update(@PathVariable Long bno, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(bno, requestDto);
    }

    @GetMapping("/api/v1/posts/{bno}")
    public PostsResponseDto findById(@PathVariable Long bno){
        return postsService.findById(bno);
    }

    @DeleteMapping("/api/v1/posts/{bno}")
    public Long postsDelete(@PathVariable Long bno){
        postsService.delete(bno);
        return bno;
    }
}
