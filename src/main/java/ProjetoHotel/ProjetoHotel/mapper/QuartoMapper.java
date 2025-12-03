package com.example.hotel.mapper;

import com.example.hotel.dto.QuartoDTO;
import com.example.hotel.entity.Quarto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuartoMapper {

    QuartoDTO toDTO(Quarto entity);

    @Mapping(target = "id", ignore = true)
    Quarto toEntity(QuartoDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(QuartoDTO dto, @MappingTarget Quarto entity);

    List<QuartoDTO> toDTOList(List<Quarto> entities);
}