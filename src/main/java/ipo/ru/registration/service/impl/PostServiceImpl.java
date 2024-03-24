package ipo.ru.registration.service.impl;

import ipo.ru.registration.dto.PostDtoIn;
import ipo.ru.registration.dto.PostDtoOut;
import ipo.ru.registration.dto.entity.PostEntity;
import ipo.ru.registration.mapper.PostMapper;
import ipo.ru.registration.repository.PostRepository;
import ipo.ru.registration.service.api.PostService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper postMapper;
    @Override
    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }

    @Override
    public PostDtoOut createPost(PostDtoIn postDtoIn) {
        PostEntity post = postMapper.convertToEntity(postDtoIn);
        postRepository.save(post);
        return PostDtoOut.builder()
                .text(post.getText())
                .createDate(post.getCreateDate())
                .build();
    }

    @Override
    @SneakyThrows
    public PostDtoOut editPost(PostDtoIn postDtoIn) {
        PostEntity post = postRepository.findById(postDtoIn.getId()).orElseThrow(Exception::new);
        postRepository.save(Optional.of(post).map(x -> {
            post.setText(postDtoIn.getText());
            post.setCreateDate(postDtoIn.getCreateDate());
            post.setUpdateDate(postDtoIn.getUpdateDate());
            return post;
        }).orElseThrow(Exception::new));
         return PostDtoOut.builder()
                .text(post.getText())
                .createDate(post.getCreateDate())
                .build();
    }

    @Override
    public PostDtoOut deleteById(UUID id) {
        postRepository.deleteById(id);
        return PostDtoOut.builder()
                .updateDate(Instant.now())
                .build();
    }
}
