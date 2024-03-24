package ipo.ru.registration.mapper;

import ipo.ru.registration.dto.PostDto;
import ipo.ru.registration.dto.entity.PostEntity;

public class PostMapper {

    public static PostDto convert(PostEntity post) {
        return PostDto.builder()
                .createDate(post.getCreateDate())
                .text(post.getText())
                .updateDate(post.getUpdateDate())
                .build();
    }
}
