package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farm service
   */
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }


  /**
   * Create farm farm.
   *
   * @param farm the farm
   * @return the farm
   */
  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Farm createFarm(@RequestBody Farm farm) {
    return farmService.insertFarm(farm);
  }

  /**
   * Gets all farms.
   *
   * @return the all farms
   */
  @GetMapping()
  @ResponseStatus(HttpStatus.OK)
  public List<Farm> getAllFarms() {
    return farmService.getAllFarms();
  }

  /**
   * Gets farm by id.
   *
   * @param farmId the farm id
   * @return the farm by id
   */
  @GetMapping("/{farmId}")
  @ResponseStatus(HttpStatus.OK)
  public Farm getFarmById(@PathVariable Long farmId) {
    return farmService.getFarmById(farmId);
  }


  /**
   * Gets crops by farm id.
   *
   * @param farmId the farm id
   * @param crop   the crop
   * @return the crops by farm id
   */
  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto getCropsByFarmId(@PathVariable Long farmId,
      @RequestBody Crop crop) {
    return farmService.insertCrop(farmId, crop);
  }

  /**
   * Gets all crops by farm id.
   *
   * @param farmId the farm id
   * @return the all crops by farm id
   */
  @GetMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getAllCropsByFarmId(@PathVariable Long farmId) {
    return farmService.getAllCropsByFarmId(farmId);
  }
}
