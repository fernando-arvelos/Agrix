package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Person;
import com.betrybe.agrix.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The type Person dto.
 */
public record PersonDto(
    Long id,
    String username,
    Role role
) {

  /**
   * From entity person dto.
   *
   * @param person the person
   * @return the person dto
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
        person.getId(),
        person.getUsername(),
        person.getRole()
    );
  }

  /**
   * Gets password.
   *
   * @return the password
   */
  @JsonIgnore
  public String getPassword() {
    return null;
  }

}
