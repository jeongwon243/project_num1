package com.jojoldu.book.springboot.domain.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Entity
public class Gets {
    @Id
    private Long id;
    private String name;
    private String phone;
    private String title;
    private Integer nul;


}
