package org.chrsblck.message.messagelog.repository;

import org.chrsblck.message.messagelog.domain.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends ElasticsearchRepository<Message, String> {
    Page<Message> findBySubject(String subject, Pageable pageable);
}
