package org.chrsblck.message.messagelog.service;

import java.util.Optional;

import org.chrsblck.message.messagelog.domain.Message;
import org.springframework.data.domain.Page;

public interface MessageService {
    Optional<Message> findById(String id);

    Page<Message> findBySubject(String subject, int page, int size);
}
