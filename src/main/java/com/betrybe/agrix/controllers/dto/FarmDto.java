package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import java.util.List;

/**
 * The type Farm dto.
 */
public record FarmDto(Long id, String name, Double size, List<Crop> crop) {

  /**
   * To farm farm.
   *
   * @return the farm
   */
  public Farm toFarm() {
    return new Farm(id, name, size, crop);
  }

}
