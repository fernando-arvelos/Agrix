package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.FertilizerService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Crop controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  private final CropService cropService;
  private final FertilizerService fertilizerService;

  /**
   * Instantiates a new Crop controller.
   *
   * @param cropService       the crop service
   * @param fertilizerService the fertilizer service
   */
  @Autowired
  public CropController(CropService cropService, FertilizerService fertilizerService) {
    this.cropService = cropService;
    this.fertilizerService = fertilizerService;
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  @GetMapping()
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> getAllCrops() {
    return cropService.getAllCrops();
  }

  /**
   * Gets crop by id.
   *
   * @param cropId the crop id
   * @return the crop by id
   */
  @GetMapping("/{cropId}")
  @ResponseStatus(HttpStatus.OK)
  public CropDto getCropById(@PathVariable Long cropId) {
    return cropService.getCropsById(cropId);
  }

  /**
   * Search crops by harvest date between list.
   *
   * @param start the start
   * @param end   the end
   * @return the list
   */
  @GetMapping("/search")
  @ResponseStatus(HttpStatus.OK)
  public List<CropDto> searchCropsByHarvestDateBetween(@RequestParam("start") LocalDate start,
      @RequestParam("end") LocalDate end) {
    List<Crop> crop = cropService.searchCropsByHarvestDateBetween(start, end);
    return crop.stream().map(CropDto::toCrop).toList();
  }

  /**
   * Associate crop with fertilizers string.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   * @return the string
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String associateCropWithFertilizers(@PathVariable Long cropId,
      @PathVariable Long fertilizerId) {
    return fertilizerService.associateCropWithFertilizers(cropId, fertilizerId);
  }

  /**
   * Gets fertilizers by crop id.
   *
   * @param cropId the crop id
   * @return the fertilizers by crop id
   */
  @GetMapping("/{cropId}/fertilizers")
  @ResponseStatus(HttpStatus.OK)
  public List<FertilizerDto> getFertilizersByCropId(@PathVariable Long cropId) {
    return fertilizerService.getFertilizersByCropId(cropId);
  }
}
