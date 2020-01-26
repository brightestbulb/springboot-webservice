package com.brightest.study.springboot.web.dto;

import com.brightest.study.springboot.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long bno;
    private String title;
    private String writer;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity){
        this.bno = entity.getBno();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.modifiedDate = entity.getModifiedDate();
    }
}
