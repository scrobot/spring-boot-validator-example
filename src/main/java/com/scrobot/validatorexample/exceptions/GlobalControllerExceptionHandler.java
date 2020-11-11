package com.scrobot.validatorexample.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@AllArgsConstructor
public class GlobalControllerExceptionHandler {

  private final ObjectMapper mapper;

  /**
   * Exception handler for {@link MethodArgumentNotValidException}.
   *
   * @param exception Exception object.
   * @param request   Web request.
   * @return {@link ResponseEntity}.
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ApiErrorResponse> validationExceptionHandler(MethodArgumentNotValidException exception, ServletWebRequest request) {
    var errors = exception.getBindingResult()
        .getAllErrors()
        .stream()
        .map(error -> ErrorRecord.builder()
            .name(((FieldError) error).getField())
            .reason(error.getDefaultMessage())
            .build())
        .collect(Collectors.toList());

    return build(exception, request, errors);
  }

  /**
   * Default exception handler.
   *
   * @param throwable Exception object.
   * @param request   Request.
   * @return {@link ResponseEntity}.
   */
  @ExceptionHandler(Throwable.class)
  public ResponseEntity<ApiErrorResponse> defaultExceptionHandler(Throwable throwable, ServletWebRequest request) {
    var annotation = throwable.getClass().getAnnotation(ResponseStatus.class);
    var status = annotation != null ? annotation.value() : HttpStatus.INTERNAL_SERVER_ERROR;

    return build(throwable, request, status, false);
  }

  private ResponseEntity<ApiErrorResponse> build(Throwable throwable, ServletWebRequest request, HttpStatus status, boolean detailed) {
    return new ResponseEntity<>(ApiErrorResponse.builder()
        .title(throwable.getClass().getSimpleName())
        .status(status.value())
        .detail(detailed ? throwable.getMessage() : "")
        .instance(request.getRequest().getRequestURI())
        .build(), status);
  }

  private ResponseEntity<ApiErrorResponse> build(MethodArgumentNotValidException throwable, ServletWebRequest request, List<ErrorRecord> errors) {
    var status = HttpStatus.BAD_REQUEST;

    return new ResponseEntity<>(ApiErrorResponse.builder()
        .title(throwable.getClass().getSimpleName())
        .status(status.value())
        .instance(request.getRequest().getRequestURI())
        .errors(errors)
        .build(), status);
  }

  @Value
  @Builder
  private static class ApiErrorResponse {
    String type;
    String title;
    int status;
    String detail;
    String instance;
    List<ErrorRecord> errors;
  }

  @Value
  @Builder
  private static class ErrorRecord {
    String name;
    String reason;
  }
}
