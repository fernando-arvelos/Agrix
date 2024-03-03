package com.betrybe.agrix.service;

import com.betrybe.agrix.controllers.dto.CropDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Farm service.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  /**
   * Instantiates a new Farm service.
   *
   * @param farmRepository the farm repository
   * @param cropRepository the crop repository
   */
  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  /**
   * Insert farm farm.
   *
   * @param farm the farm
   * @return the farm
   */
  public Farm insertFarm(Farm farm) {
    return farmRepository.save(farm);
  }

  /**
   * Gets all farms.
   *
   * @return the all farms
   */
  public List<Farm> getAllFarms() {
    return farmRepository.findAll();
  }

  /**
   * Gets farm by id.
   *
   * @param id the id
   * @return the farm by id
   */
  public Farm getFarmById(Long id) {
    return farmRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Fazenda não encontrada!"));
  }

  /**
   * Insert crop optional.
   *
   * @param id   the id
   * @param crop the crop
   * @return the optional
   */
  public CropDto insertCrop(Long id, Crop crop) {
    Optional<Farm> optionalFarm = farmRepository.findById(id);
    if (optionalFarm.isPresent()) {
      crop.setFarm(optionalFarm.get());
      Crop newCrop = cropRepository.save(crop);
      return CropDto.toCrop(newCrop);
    }

    throw new NotFoundException("Fazenda não encontrada!");
  }

  /**
   * Gets all crops by farm id.
   *
   * @param id the id
   * @return the all crops by farm id
   */
  public List<CropDto> getAllCropsByFarmId(Long id) {
    Optional<Farm> optionalFarm = farmRepository.findById(id);
    if (optionalFarm.isPresent()) {
      return cropRepository.findAll()
          .stream().filter(crop -> crop.getFarm().getId().equals(id))
          .map(CropDto::toCrop)
          .toList();
    }

    throw new NotFoundException("Fazenda não encontrada!");
  }

}
