package ipo.ru.registration.mapper;

import ipo.ru.registration.dto.PostDtoIn;
import ipo.ru.registration.dto.PostDtoOut;
import ipo.ru.registration.dto.entity.PostEntity;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@Component
public class PostMapper {

    public static PostDtoOut convertToOut(PostEntity post) {
        return PostDtoOut.builder()
                .id(post.getId())
                .createDate(post.getCreateDate())
                .text(post.getText())
                .updateDate(post.getUpdateDate())
                .build();
    }
    @SneakyThrows
    public PostEntity convertToEntity(PostDtoIn postDtoIn) {

        return PostEntity.builder()
                .text(postDtoIn.getText())
                .createDate(Optional.of(postDtoIn.getCreateDate()).orElse(Instant.now()))
                .updateDate(Optional.of(postDtoIn.getUpdateDate()).orElse(null))
                .id(Optional.of(postDtoIn.getId()).orElseThrow((Supplier<Throwable>) Exception::new))
                .build();
    }
}
