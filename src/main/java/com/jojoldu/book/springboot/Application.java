package com.jojoldu.book.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;


@SpringBootApplication
/*스프링 부트의 자동설정, 스프링 bean읽기 생성을 모두 자동으로 설정
  해당 클래스는 항상 프로젝트 최상단에 존재해야함
 */
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
