package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
/*기본생성자 자동추가*/
@Entity
/*Entity 테이블과 링크될 클래스*/
public class Posts {
    @Id
    /*Id pk필드*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* pk생성규칙*/
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    /*빌더 패턴 클래스*/
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
