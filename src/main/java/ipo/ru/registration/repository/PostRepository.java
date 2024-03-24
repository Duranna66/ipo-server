package ipo.ru.registration.repository;

import ipo.ru.registration.dto.entity.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends MongoRepository<PostEntity, UUID> {
    @Override
    List<PostEntity> findAll();
}
