package com.betrybe.agrix.service;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.repositories.CropRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository the crop repository
   */
  @Autowired
  public CropService(CropRepository cropRepository) {
    this.cropRepository = cropRepository;
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  public List<CropDto> getAllCrops() {

    return cropRepository.findAll().stream()
        .map(CropDto::toCrop).toList();
  }

  /**
   * Gets crops by id.
   *
   * @param id the id
   * @return the crops by id
   */
  public CropDto getCropsById(Long id) {
    Optional<Crop> optionalCrop = cropRepository.findById(id);
    if (optionalCrop.isPresent()) {
      Crop cropGet = optionalCrop.get();
      return CropDto.toCrop(cropGet);
    }

    throw new NotFoundException("Plantação não encontrada!");
  }

  public List<Crop> searchCropsByHarvestDateBetween(LocalDate start, LocalDate end) {
    return cropRepository.findByHarvestDateBetween(start, end);
  }

}
