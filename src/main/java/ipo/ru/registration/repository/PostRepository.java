package ipo.ru.registration.repository;

import ipo.ru.registration.dto.entity.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostRepository extends MongoRepository<PostEntity, UUID> {
    @Override
    List<PostEntity> findAll();

    @Override
    <S extends PostEntity> S save(S entity);

    @Override
    Optional<PostEntity> findById(UUID uuid);

    @Override
    void deleteById(UUID uuid);
}
