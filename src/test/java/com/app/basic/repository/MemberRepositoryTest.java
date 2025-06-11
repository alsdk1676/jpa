package com.app.basic.repository;

import com.app.basic.domain.entity.Member;
import com.app.basic.domain.type.MemberGender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional @Commit
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void memberSaveTest() {
        Member member = new Member();
        member.setMemberEmail("test1234@gmail.com");
        member.setMemberPassword("1234");
        member.setMemberName("서민아");
        member.setMemberAge(26);
        member.setMemberGender(MemberGender.FEMALE);

        memberRepository.save(member);
    }

    @Test
    public void memberFindTest() {
        Optional<Member> member = memberRepository.findById(252L);
        log.info("member : {}", member.orElseThrow(RuntimeException::new));
    }

    @Test
    public void memberUpdateTest() {
//        (영속) => setter 감지
        Optional<Member> foundMember = memberRepository.findById(252L);
        foundMember.ifPresent((member) -> {
            member.setMemberName("민아");
        });
    }

    @Test
    public void memberFindAllTest() {
//        memberRepository.findAll().stream().map(Member::toString).forEach(log::info);
        List<Member> memberList = memberRepository.findAll();
        log.info("memberList : {}", memberList);

    }

//    회원 1명 삭제
    @Test
    public void memberDeleteTest() {
        Optional<Member> foundMember = memberRepository.findById(2L);
        foundMember.ifPresent((member) -> {
            memberRepository.delete(member);
        });
    }


}