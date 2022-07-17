package com.jojoldu.book.springboot.infra.Posts;

import com.jojoldu.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    //entity 기본클래스와 repository는 함께 위치해야함
    Optional<Posts> findById(Long id);
}
