package com.brightest.study.springboot.web.dto;

import com.brightest.study.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long bno;
    private String title;
    private String content;
    private String writer;

    public PostsResponseDto(Posts entity){
        this.bno = entity.getBno();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
    }
}
