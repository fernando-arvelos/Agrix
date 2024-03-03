package com.betrybe.agrix.exception;


/**
 * The type Farm not found exception.
 */
public class NotFoundException extends RuntimeException {

  /**
   * Instantiates a new Farm not found exception.
   *
   * @param message the message
   */
  public NotFoundException(String message) {
    super(message);
  }

}
