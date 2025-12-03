package com.example.hotel.mapper;

import com.example.hotel.dto.TipoQuartoDTO;
import com.example.hotel.entity.TipoQuarto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoQuartoMapper {

    TipoQuartoDTO toDTO(TipoQuarto entity);

    @Mapping(target = "id", ignore = true)
    TipoQuarto toEntity(TipoQuartoDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(TipoQuartoDTO dto, @MappingTarget TipoQuarto entity);

    List<TipoQuartoDTO> toDTOList(List<TipoQuarto> entities);
}