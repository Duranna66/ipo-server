package ipo.ru.registration.service.impl;

import ipo.ru.registration.dto.PostDto;
import ipo.ru.registration.dto.entity.PostEntity;
import ipo.ru.registration.repository.PostRepository;
import ipo.ru.registration.service.api.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    @Override
    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }
}
