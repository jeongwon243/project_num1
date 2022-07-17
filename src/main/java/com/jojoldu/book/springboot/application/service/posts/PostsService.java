package com.jojoldu.book.springboot.application.service.posts;

import com.jojoldu.book.springboot.domain.posts.Gets;
import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.infra.Gets.GetsCustomRepository;
import com.jojoldu.book.springboot.infra.Posts.PostsCustomRepository;
import com.jojoldu.book.springboot.interfaces.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
/*final필드 생성자 자동생성*/
@Service
public class PostsService {

    public final PostsCustomRepository postsCustomRepository;

    public final GetsCustomRepository getsCustomRepository;

    public PostsResponseDto excute(Long id){
        Optional<Posts> posts = Optional.ofNullable(postsCustomRepository.findByOne(id).orElseThrow(()->new IllegalArgumentException("해당 아이디가 없습니다.")));
        Gets gets = getsCustomRepository.findByName(posts.get().getAuthor());
        return new PostsResponseDto(gets);
    }

}
