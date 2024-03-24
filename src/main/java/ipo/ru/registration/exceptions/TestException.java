package ipo.ru.registration.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class TestException  {
    private final String url;
    private final HttpMethod httpMethod;
    private final HttpStatus httpStatus;
    private final String timeStamp;
    private final String message;
}
