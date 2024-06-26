package ipo.ru.registration.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ipo.ru.registration.exceptions.PostException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/v1/test")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "test operating", description = "Receive results for checking")
public class TestController {


    @GetMapping("/public")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Receive results for checking")
    @ApiResponse(responseCode = "200", description = "complete operating",
    content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "400", description = "not correct",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "500", description = "smth bad",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    public String getpublic() {
        return "public message " + new Date();
    }
    @GetMapping("/moderator-access")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Receive results for checking")
    @ApiResponse(responseCode = "200", description = "complete operating",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "400", description = "not correct",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "500", description = "smth bad",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    public String getModerator() {
        return "moderator message " + new Date();
    }
    @GetMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Receive results for checking")
    @ApiResponse(responseCode = "200", description = "complete operating",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "400", description = "not correct",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "500", description = "smth bad",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    public String getUser() {
        return "user message " + new Date();
    }
    @GetMapping("/admin-access")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Receive results for checking")
    @ApiResponse(responseCode = "200", description = "complete operating",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "400", description = "not correct",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    @ApiResponse(responseCode = "500", description = "smth bad",
            content = @Content(schema = @Schema(implementation = PostException.class)))
    public String getAdmin() {
        return "admin message " + new Date();
    }


}
