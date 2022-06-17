package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
/* Junit에 내장된 실행자 외 다른실행자 실행 스프링부트와 junit사이 연결*/
@WebMvcTest(controllers = HelloController.class)
/* mvc에 집중할 수 있는 어노테이션 */
public class HelloControllerTest {

    @Autowired
    /* 스프링이 관리하는 빈을 주입*/
    private MockMvc mvc;
    /* 웹API를 테스트할 때 사용, 스프링 mvc테스트 시작점, HTTP,GET,POST에대한 API테스트 가능*/
    
    @Test
    public void hello가_리턴된다() throws Exception{

        String hello = "hello";

        mvc.perform(get("/hello")) // mockmvc를 통해 /hello주소로 요청
                .andExpect(status().isOk()) // http Header의 상태검증.(200,404,500같은 에러)
                .andExpect(content().string(hello)); //응답 본문 내용을 검증 hello리턴하는지 확인
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "정원";
        int amount = 10000;

        /* param API테스트 할때 사용될 요청 파라미터 설정(String만 허용)
        *  jsonPath  json값을 필드별로 검증할 수 있는 메소드
        * */
        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}
