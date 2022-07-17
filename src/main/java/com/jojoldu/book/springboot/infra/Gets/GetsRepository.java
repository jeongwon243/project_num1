package com.jojoldu.book.springboot.infra.Gets;

import com.jojoldu.book.springboot.domain.posts.Gets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GetsRepository extends JpaRepository<Gets, Long> {
    Gets findByName(String name);
}
