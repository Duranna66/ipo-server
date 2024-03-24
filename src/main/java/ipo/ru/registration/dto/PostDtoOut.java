package ipo.ru.registration.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@Schema(description = "Object of post")
public class PostDtoOut {

    @Schema(description = "id of post")
    private UUID id;
    @Schema(description = "text of post")
    private String text;
    @Schema(description = "time of creation")
    private Instant createDate = Instant.now();
    @Schema(description = "update date time of post")
    private Instant updateDate;
}
