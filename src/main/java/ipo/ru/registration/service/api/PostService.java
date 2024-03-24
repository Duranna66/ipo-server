package ipo.ru.registration.service.api;

import ipo.ru.registration.dto.PostDtoIn;
import ipo.ru.registration.dto.PostDtoOut;
import ipo.ru.registration.dto.entity.PostEntity;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<PostEntity> findAll();

    PostDtoOut createPost(PostDtoIn postDtoIn);

    PostDtoOut editPost(PostDtoIn postDtoIn);

    PostDtoOut deleteById(UUID id);
}
