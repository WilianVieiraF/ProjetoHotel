package com.example.hotel.mapper;

import com.example.hotel.dto.HospedeDTO;
import com.example.hotel.entity.Hospede;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HospedeMapper {

    HospedeDTO toDTO(Hospede entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    Hospede toEntity(HospedeDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "reservas", ignore = true)
    void updateEntityFromDTO(HospedeDTO dto, @MappingTarget Hospede entity);

    List<HospedeDTO> toDTOList(List<Hospede> entities);
}