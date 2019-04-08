package com.beam.sample.mail.model;
import lombok.experimental.Accessors;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Accessors(chain = true)
public class Base {

    @Id
    @Getter
    @Setter
    private String id ;


}
