package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌
 각 메소드마다 @ResponseBody 선언했던 것을 한번에 사용하도록 해줌
 */
public class HelloController {

    @GetMapping("/hello")
    /* HTTP method인 get요청을 받을 수 있는 API
       예전에는 @RequestMapping(method = RequestMethod.GET)으로사용
       /hello로 요청이 오면 문자열hello를 반환
     */
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    /* @RequestParam 외부에서 API로 넘긴 파라미터 가져오는 어노테이션*/
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}

