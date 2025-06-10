package com.app.basic.domain.entity;

import com.app.basic.domain.type.MemberGender;
import jakarta.persistence.*;
import lombok.*;

// 1. PK키가 필요하다
// 2. 기본 생성자, 초기화 생성자, Getter, Setter, ToString 재정의, HashEquals
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString @EqualsAndHashCode
@Entity @Table(name = "TBL_MEMBER")
public class Member {

//    @GeneratedValue(strategy = GenerationType.AUTO) // default 오라클 -> SEQUENCE, MySQL이라면 IDENTITY
    @Id
    @GeneratedValue // auto, JPA가 시퀀스를 관리
    private Long id;
    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;
    private String memberName;
    private String memberPassword;
    private Integer memberAge;
//    private String memberGender;
    @Enumerated(EnumType.STRING)
    private MemberGender memberGender;
}
