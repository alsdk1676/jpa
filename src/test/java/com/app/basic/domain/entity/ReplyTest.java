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
        reply.setReplyContent("내용4");
        reply.setReplyWriter("유저4");
        reply.setReplyStatus(ReplyStatus.PUBLIC);

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

}