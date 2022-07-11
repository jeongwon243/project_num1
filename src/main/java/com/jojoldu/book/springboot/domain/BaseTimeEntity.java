package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
/* jpa entity클래스들이 baseTimeEntity을 상속할 경우 필드들도 칼럼으로 인식하도록 함.*/
@EntityListeners(AuditingEntityListener.class)
/* baseTimeEntity클래스에 auditing기능을 포함시킴*/
public class BaseTimeEntity {

    @CreatedDate
    /*entity가 생성되어 저장될때 시간이 자동저장*/
    private LocalDateTime createdDate;

    @LastModifiedDate
    /*조회한 entity의 값을 변경할 때 시간이 자동저장됨*/ 
    private LocalDate modifiedDate;
/*git test*/

}
