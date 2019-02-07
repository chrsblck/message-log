package org.chrsblck.message.messagelog.service;

import java.util.Optional;

import org.chrsblck.message.messagelog.domain.Message;
import org.chrsblck.message.messagelog.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Optional<Message> findById(String id) {
        return messageRepository.findById(id);
    }

    @Override
    public Page<Message> findBySubject(String subject, int page, int size) {
        return messageRepository.findBySubject(subject, PageRequest.of(page, size));
    }
}
