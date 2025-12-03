package ProjetoHotel.ProjetoHotel.mapper;

import ProjetoHotel.ProjetoHotel.dto.TipoQuartoDTO;
import ProjetoHotel.ProjetoHotel.entity.TipoQuarto;
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