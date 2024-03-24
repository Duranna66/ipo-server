package ipo.ru.registration.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Object of post")
public class PostDtoIn {
        @Schema(description = "id of post")
        private UUID id;
        @Schema(description = "text of post")
        private String text;
        @Schema(description = "date of update of post")
        private Instant updateDate;
        @Schema(description = "create date of post")
        private Instant createDate;

}
