package ipo.ru.registration.service.api;

import ipo.ru.registration.dto.PostDto;
import ipo.ru.registration.dto.entity.PostEntity;

import java.util.List;

public interface PostService {

    List<PostEntity> findAll();
}
