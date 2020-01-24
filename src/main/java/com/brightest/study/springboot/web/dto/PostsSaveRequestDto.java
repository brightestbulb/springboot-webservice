package com.brightest.study.springboot.web.dto;

import com.brightest.study.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String writer;

    @Builder
    public PostsSaveRequestDto(String title, String content, String writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }

}
