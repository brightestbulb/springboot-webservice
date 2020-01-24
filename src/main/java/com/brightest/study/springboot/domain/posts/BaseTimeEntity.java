package com.brightest.study.springboot.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass  // JPA Entity 클래스들이 이 클래스를 상속할 경우 필드들(createdDate, ModifiedDate) 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {  // 모든 Entity의 상위 클래스가 되어 Entity들의 createdDate, ModifiedDate를 자동 관리

    @CreatedDate  // Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate  // 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;

}
