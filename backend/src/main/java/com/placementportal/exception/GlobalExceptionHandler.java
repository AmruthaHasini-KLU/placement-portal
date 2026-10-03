package com.placementportal.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    record ErrorResponse(Instant timestamp, int status, String error, String message, String path) {}
    @ExceptionHandler(ApiException.class)
    ResponseEntity<ErrorResponse> api(ApiException e, HttpServletRequest r) { return response(e.getStatus(),e.getMessage(),r); }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorResponse> validation(MethodArgumentNotValidException e, HttpServletRequest r) {
        String message = e.getBindingResult().getFieldErrors().stream().map(x -> x.getField()+": "+x.getDefaultMessage()).collect(Collectors.joining("; "));
        return response(HttpStatus.BAD_REQUEST,message,r);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    ResponseEntity<ErrorResponse> integrity(DataIntegrityViolationException e, HttpServletRequest r) { return response(HttpStatus.CONFLICT,"The request conflicts with existing data",r); }
    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponse> unexpected(Exception e, HttpServletRequest r) { return response(HttpStatus.INTERNAL_SERVER_ERROR,"Unexpected server error",r); }
    private ResponseEntity<ErrorResponse> response(HttpStatus s, String m, HttpServletRequest r) {
        return ResponseEntity.status(s).body(new ErrorResponse(Instant.now(),s.value(),s.getReasonPhrase(),m,r.getRequestURI()));
    }
}
