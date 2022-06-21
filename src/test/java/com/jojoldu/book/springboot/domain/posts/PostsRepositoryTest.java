package com.jojoldu.book.springboot.domain.posts;

import javafx.geometry.Pos;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    /*junit단위테스트 끝날때마다 수행되는 메서드 지정*/
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){

        //given
        String title = "테스트 게시글";
        String content = "테스트본문";
        /*.save inser/update수행 */
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("jeongwon")
                .build());
        /*객체 생성할 수 있는 빌더를 builer()함수를 통해 얻고, build()를 통해 빌더를 작동시켜 객체 생성*/

        //when
        /*.findAll 모든 데이터 조회*/
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){

        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate()+",modifiedDate = " + posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(LocalDate.from(now));

    }
}

