package org.chrsblck.message.messagelog.controller;

import java.util.Optional;

import org.chrsblck.message.messagelog.domain.Message;
import org.chrsblck.message.messagelog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/message")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Message>> getMessageById(@PathVariable String id) {
        return Optional.of(messageService.findById(id))
                       .map(message -> ResponseEntity.ok().body(message))
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public Page<Message> getMessageBySubject(@RequestParam String subject,
                                             @RequestParam(required = false, defaultValue = "0") int page,
                                             @RequestParam(required = false, defaultValue = "1") int size) {
        return messageService.findBySubject(subject, page, size);
    }
}