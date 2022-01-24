package com.udacity.vehicles.api;

import com.udacity.vehicles.service.CarNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Implements the Error controller related to any errors handled by the Vehicles API
 */
@ControllerAdvice
public class ErrorController extends ResponseEntityExceptionHandler {

    private static final String DEFAULT_VALIDATION_FAILED_MESSAGE = "Validation failed";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status,
            WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage()).collect(
                        Collectors.toList());

        ApiError apiError = new ApiError(DEFAULT_VALIDATION_FAILED_MESSAGE, errors);
        return handleExceptionInternal(ex, apiError, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = CarNotFoundException.class)
    public ResponseEntity<StandardError> carNotFoundException(CarNotFoundException carNotFoundException,
            HttpServletRequest httpServletRequest) {
        StandardError standardError = new StandardError(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not found",
                carNotFoundException.getMessage(),
                httpServletRequest.getRequestURI()
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(standardError);
    }
}

