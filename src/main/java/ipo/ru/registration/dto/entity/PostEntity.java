package ipo.ru.registration.dto.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.rmi.server.UID;
import java.time.Instant;
import java.util.UUID;


@Document(collection = "post")
@Data
@ToString
@EqualsAndHashCode
public class PostEntity {
    @Id
    private UUID id;
    private String text;
    private Instant createDate = Instant.now();
    private Instant updateDate;
}
