package org.chrsblck.message.messagelog.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "log", indexStoreType = "message")
public class Message {

    @Id
    private String id;

    @Field(type = FieldType.Keyword)
    private String to;

    @Field(type = FieldType.Keyword)
    private String from;

    @Field(type = FieldType.Keyword)
    private String subject;
}

