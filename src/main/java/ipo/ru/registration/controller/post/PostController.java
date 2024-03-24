package ipo.ru.registration.controller.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ipo.ru.registration.dto.PostDtoIn;
import ipo.ru.registration.dto.PostDtoOut;
import ipo.ru.registration.exceptions.PostException;
import ipo.ru.registration.mapper.PostMapper;
import ipo.ru.registration.repository.PostRepository;
import ipo.ru.registration.service.api.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j

@Tag(name = "post operating", description = "create, delete, edit posts")
public class PostController {

private  final PostService postService;

    @GetMapping("/showPosts")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Receive all posts")
    @ApiResponse(responseCode = "200", description = "complete operating",
    content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "400", description = "not correct",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "500", description = "smth bad",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    public List<PostDtoOut> getPosts() {
        return postService.findAll().stream().map(PostMapper::convertToOut).toList();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Create post")
    @ApiResponse(responseCode = "200", description = "complete operating",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "400", description = "not correct",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "500", description = "smth bad",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    public PostDtoOut createPost(
            @Parameter(description = "body of post")
            @Valid @RequestBody PostDtoIn postDtoIn
            ) {
        return postService.createPost(postDtoIn);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Update post")
    @ApiResponse(responseCode = "200", description = "complete operating",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "400", description = "not correct",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "500", description = "smth bad",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    public PostDtoOut editPost(
            @Parameter(description = "body of post")
            @Valid @RequestBody PostDtoIn postDtoIn
    ) {
        return postService.editPost(postDtoIn);
    }


    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Delete post")
    @ApiResponse(responseCode = "200", description = "complete operating",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "400", description = "not correct",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "500", description = "smth bad",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    public PostDtoOut editPost(
            @Parameter(description = "body of post")
            @Valid @PathVariable UUID id
            ) {
        return postService.deleteById(id);
    }

}
