package com.jojoldu.book.springboot.infra.Gets;

import com.jojoldu.book.springboot.domain.posts.Gets;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class GetsCustomRepository {

    private final GetsRepository getsRepository;

    public Gets findByName(String author){
        Gets entity = getsRepository.findByName(author);
        return entity;
    }
}
