package com.beam.sample.mail.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Accessors(chain = true)
@TypeAlias("Mail")
@Document("Mail")
public class Mail extends Base {

    @Getter
    @Setter
    private String content;

    @Getter
    @Setter
    private String contentHeader;

    @Getter
    @Setter
    private boolean read;

    @Getter
    @Setter
    private Date date;

    @DBRef
    @Getter
    @Setter
    private User sender;

    @DBRef
    @Getter
    @Setter
    private User receiver;


}
