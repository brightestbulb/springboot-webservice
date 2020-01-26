package com.brightest.study.springboot.web;

import com.brightest.study.springboot.service.posts.PostsService;
import com.brightest.study.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{bno}")
    public String postsUpdate(@PathVariable Long bno, Model model){

        PostsResponseDto dto = postsService.findById(bno);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
