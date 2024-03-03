package com.betrybe.agrix.service;

import com.betrybe.agrix.controllers.dto.FertilizerDto;
import com.betrybe.agrix.exception.NotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fertilizer service.
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;
  private final CropRepository cropRepository;

  /**
   * Instantiates a new Fertilizer service.
   *
   * @param fertilizerRepository the fertilizer repository
   * @param cropRepository       the crop repository
   */
  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository,
      CropRepository cropRepository) {
    this.fertilizerRepository = fertilizerRepository;
    this.cropRepository = cropRepository;
  }

  /**
   * Create fertilizer fertilizer.
   *
   * @param fertilizer the fertilizer
   * @return the fertilizer
   */
  public FertilizerDto createFertilizer(Fertilizer fertilizer) {
    return FertilizerDto.toFertilizerDto(fertilizerRepository.save(fertilizer));
  }

  /**
   * Gets all fertilizers.
   *
   * @return the all fertilizers
   */
  public List<FertilizerDto> getAllFertilizers() {
    return fertilizerRepository.findAll().stream()
        .map(FertilizerDto::toFertilizerDto).toList();
  }

  /**
   * Gets fertilizer by id.
   *
   * @param id the id
   * @return the fertilizer by id
   */
  public FertilizerDto getFertilizerById(Long id) {
    Optional<Fertilizer> fertilizerById = fertilizerRepository.findById(id);
    if (fertilizerById.isPresent()) {
      return FertilizerDto.toFertilizerDto(fertilizerById.get());
    }
    throw new NotFoundException("Fertilizante não encontrado!");
  }

  /**
   * Associate crop with fertilizers string.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   * @return the string
   */
  public String associateCropWithFertilizers(Long cropId, Long fertilizerId) {
    Optional<Fertilizer> fertilizer = fertilizerRepository.findById(fertilizerId);
    Optional<Crop> crop = cropRepository.findById(cropId);

    if (fertilizer.isPresent() && crop.isPresent()) {
      crop.get().getFertilizers().add(fertilizer.get());
      cropRepository.save(crop.get());
      return "Fertilizante e plantação associados com sucesso!";
    } else if (fertilizer.isEmpty() && crop.isPresent()) {
      throw new NotFoundException("Fertilizante não encontrado!");
    }
    throw new NotFoundException("Plantação não encontrada!");
  }

  /**
   * Gets fertilizers by crop id.
   *
   * @param cropId the crop id
   * @return the fertilizers by crop id
   */
  public List<FertilizerDto> getFertilizersByCropId(Long cropId) {
    Optional<Crop> crop = cropRepository.findById(cropId);
    if (crop.isPresent()) {
      return crop.get().getFertilizers().stream()
          .map(FertilizerDto::toFertilizerDto).toList();
    }
    throw new NotFoundException("Plantação não encontrada!");
  }
}