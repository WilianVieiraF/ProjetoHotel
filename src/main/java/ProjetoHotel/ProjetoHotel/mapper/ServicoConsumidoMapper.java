package com.example.hotel.mapper;

import com.example.hotel.dto.ServicoConsumidoDTO;
import com.example.hotel.entity.ServicoConsumido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicoConsumidoMapper {

    @Mapping(source = "hospede.id", target = "hospede.id")
    @Mapping(source = "hospede.nome", target = "hospede.nome")
    @Mapping(source = "servico.id", target = "servico.id")
    @Mapping(source = "servico.descricao", target = "servico.descricao")
    ServicoConsumidoDTO toDTO(ServicoConsumido entity);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(ServicoConsumidoDTO dto, @MappingTarget ServicoConsumido entity);

    ServicoConsumido toEntity(ServicoConsumidoDTO dto);

    List<ServicoConsumidoDTO> toDTOList(List<ServicoConsumido> entities);
}