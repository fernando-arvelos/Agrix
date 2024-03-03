package com.betrybe.agrix.controllers.dto;


import com.betrybe.agrix.models.entities.Person;

/**
 * The type Person create dto.
 */
public record PersonCreateDto(
    String username,
    String password,
    String role) {

  /**
   * To entity person.
   *
   * @return the person
   */
  public Person toEntity() {
    return new Person(null, username, password, role);
  }
}
