package com.betrybe.agrix.controllers.dto;


import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.security.Role;

/**
 * The type Person create dto.
 */
public record PersonCreateDto(
    String username,
    String password,
    Role role) {

  /**
   * To entity person.
   *
   * @return the person
   */
  public Person toEntity() {
    return new Person(null, username, password, role);
  }
}
