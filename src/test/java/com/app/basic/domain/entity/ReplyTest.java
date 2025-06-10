package com.app.basic.domain.entity;

import com.app.basic.domain.type.ReplyStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j @Transactional @Commit
class ReplyTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    public void replyInsertTest() {
        Reply reply = new Reply();
        reply.setReplyContent("게시글3");
        reply.setReplyWriter("서민아");
        reply.setReplyStatus(ReplyStatus.PUBLIC);

//        영속
        entityManager.persist(reply);
        log.info(reply.toString());
    }

    @Test
    public void replySelectTest() {
        Reply reply = new Reply();
        Reply foundReply = entityManager.find(Reply.class, 2L);
        log.info(foundReply.toString());
    }

    @Test
    public void replyUpdateTest() {
        Reply foundReply = entityManager.find(Reply.class, 2L);
        entityManager.detach(foundReply);
        foundReply.setReplyContent("수정된 내용2");
        entityManager.merge(foundReply);
    }

    @Test
    public void replyDeleteTest() {
        Reply foundReply = entityManager.find(Reply.class, 52L);
        entityManager.remove(foundReply);
        log.info(foundReply.toString());
    }

//    JPA QL
    @Test
    public void replySelectAllTest() {
//        Reply foundReply = entityManager.find(Reply.class, 1L); // find : 단일 조회
//        JPA QL
//        1) *(와일드 카드) 사용이 불가능하다.
//        테이블에 알리아스(소문자)를 붙여서 모든 데이터를 조회할 수 있다.
//        2) FROM절에서 가져오는 테이블은 DB의 쿼리 테이블이 아니라 엔터티 객체이다.
//        3) 타입을 알려주어야 한다.
        entityManager.createQuery("SELECT r FROM Reply r").getResultList();
        log.info("JPA QL 데이터 조회 : {}", entityManager.createQuery("SELECT r FROM Reply r", Reply.class).getResultList().toString());

        entityManager.createQuery("SELECT r FROM Reply r WHERE r.id = :id", Reply.class).setParameter("id", 152L).getSingleResult().toString();
        log.info("단일 행 조회 : {}", entityManager.createQuery("SELECT r FROM Reply r WHERE r.id = :id", Reply.class).setParameter("id", 152L).getSingleResult().toString());
    }

}