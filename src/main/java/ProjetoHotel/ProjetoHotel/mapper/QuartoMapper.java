package ProjetoHotel.ProjetoHotel.mapper;

import ProjetoHotel.ProjetoHotel.dto.QuartoDTO;
import ProjetoHotel.ProjetoHotel.entity.Quarto;
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