package ipo.ru.registration.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final List<Class<? extends Exception>> EXCEPTIONS_STATUS_400 = List.of(
            MethodArgumentNotValidException.class,
            IOException.class
    );
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error("exception handler catch exception: {}", ex.getMessage());
        return handleExceptionInternal(ex, createErrorException(ex), new HttpHeaders(), defineStatusCode(ex), request);
    }

    private HttpStatusCode defineStatusCode(Exception ex) {
        if(EXCEPTIONS_STATUS_400.contains(ex.getClass())) {
            return HttpStatusCode.valueOf(400);
        }
        return HttpStatusCode.valueOf(500);
    }

    private PostException createErrorException(Exception exception) {
        return PostException.builder()
                .message(exception.getMessage())
                .timeStamp(ZonedDateTime.now().toString())
                .build();

    }
}
