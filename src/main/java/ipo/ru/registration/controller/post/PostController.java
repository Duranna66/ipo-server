package ipo.ru.registration.controller.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ipo.ru.registration.dto.PostDto;
import ipo.ru.registration.dto.entity.PostEntity;
import ipo.ru.registration.exceptions.TestException;
import ipo.ru.registration.mapper.PostMapper;
import ipo.ru.registration.repository.PostRepository;
import ipo.ru.registration.service.api.PostService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/post")
@RequiredArgsConstructor
@Slf4j

@Tag(name = "post operating", description = "create, delete, edit posts")
public class PostController {

private  final PostService postService;
private  final PostRepository postRepository;

@PostConstruct
private void fillDb() {
    if(postRepository.findAll() != null) {
        return;
    }
    List<PostEntity> list = new ArrayList<>();
    for(int i = 0; i < 10; i++) {
        var postEntity = new PostEntity();
        postEntity.setId(UUID.randomUUID());
        postEntity.setText("test" + i);
        list.add(postEntity);
    }
    log.info("added");
    postRepository.saveAll(list);
}
    @GetMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(description = "Receive all posts")
    @ApiResponse(responseCode = "200", description = "complete operating",
    content = @Content(schema = @Schema(implementation = TestException.class)))
    @ApiResponse(responseCode = "400", description = "not correct",
            content = @Content(schema = @Schema(implementation = TestException.class)))
    @ApiResponse(responseCode = "500", description = "smth bad",
            content = @Content(schema = @Schema(implementation = TestException.class)))
    public List<PostDto> getTest() {

        return postService.findAll().stream().map(PostMapper::convert).toList();
    }


}
