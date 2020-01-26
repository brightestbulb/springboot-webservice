package com.brightest.study.springboot.service.posts;

import com.brightest.study.springboot.domain.posts.Posts;
import com.brightest.study.springboot.domain.posts.PostsRepository;
import com.brightest.study.springboot.web.dto.PostsListResponseDto;
import com.brightest.study.springboot.web.dto.PostsResponseDto;
import com.brightest.study.springboot.web.dto.PostsSaveRequestDto;
import com.brightest.study.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getBno();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){

        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public PostsResponseDto findById(Long bno){
        Posts entity = postsRepository.findById(bno)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+bno));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long bno){
        Posts posts = postsRepository.findById(bno)
            .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+bno));
        postsRepository.delete(posts);
    }

}
