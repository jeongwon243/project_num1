package com.jojoldu.book.springboot.infra.Posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class PostsCustomRepository{

    @Autowired
    private final PostsRepository postsRepository;

    public Optional<Posts> findByOne(Long id){
        Optional<Posts> entity = Optional.ofNullable(postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 아이디가 없습니다. id ="+id)));
        return entity;
    }
}
