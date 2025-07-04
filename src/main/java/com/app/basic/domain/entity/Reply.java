package com.app.basic.domain.entity;

import com.app.basic.domain.type.MemberGender;
import com.app.basic.domain.type.ReplyStatus;
import jakarta.persistence.*;
import lombok.*;

// 1. PK키가 필요하다
// 2. 기본 생성자, 초기화 생성자, Getter, Setter, ToString 재정의, HashEquals
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true) // 지정한 컬럼만 비교
@Entity @Table(name = "TBL_REPLY")
public class Reply {

    @Id @GeneratedValue
//    @EqualsAndHashCode.Include 포함
    private Long id;
//    @EqualsAndHashCode.Exclude 제거
    private String replyContent;
    private String replyWriter;
    @Enumerated(EnumType.STRING)
    private ReplyStatus replyStatus;
}
