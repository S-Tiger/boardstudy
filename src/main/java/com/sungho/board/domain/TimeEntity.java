package com.sungho.board.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //Entity 클래스들이 상속받을경우 필드들(createdDate,modifiedDate)을 자동으로 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) //해당 클래스에 Auditing기능을 사용한다는 것을 알리는 어노테이션
public class TimeEntity {

    @CreatedDate //데이터 생성 시간
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate //데이터 마지막수정 시간
    private LocalDateTime modifiedDate;
}
