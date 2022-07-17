package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
/*기본생성자 자동추가 매개변수가 없는 생성자를 자동생성. 일부 필수 필드를 빠뜨린채 생성하는 일 방지*/
@Entity
/*Entity 테이블과 링크될 클래스*/
public class Posts {
        //extends BaseTimeEntity {
    @Id
    /*Id pk필드*/
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* pk생성규칙 IDENTITY방식 - AUTO_INCREMENT를 사용해 DB에서 자동으로IP할당하는 방식*/
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    /*빌더 패턴 클래스*/
    /*garden branch윤자씨바보*/
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
