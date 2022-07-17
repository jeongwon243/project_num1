package com.jojoldu.book.springboot.interfaces.dto;

import com.jojoldu.book.springboot.domain.posts.Gets;
import com.jojoldu.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String name;
    private Integer nul;
    private String phone;
    private String title;


    public PostsResponseDto(Gets entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.name = entity.getName();
        this.nul = entity.getNul();
        this.phone = entity.getPhone();
    }
}
