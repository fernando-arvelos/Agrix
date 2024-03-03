package com.betrybe.agrix.controllers.dto;

/**
 * The type Response dto.
 */
public record ResponseDto<T>(String message, T data) {

}
