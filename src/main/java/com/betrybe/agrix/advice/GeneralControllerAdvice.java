package com.betrybe.agrix.advice;

import com.betrybe.agrix.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Exception handler not found.
 */
@ControllerAdvice
public class GeneralControllerAdvice {

  /**
   * Farm not found exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler({
      NotFoundException.class,
  })
  public ResponseEntity<String> handleNotFound(RuntimeException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }

}
