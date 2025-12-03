package ProjetoHotel.ProjetoHotel.mapper;

import ProjetoHotel.ProjetoHotel.dto.ServicoDTO;
import ProjetoHotel.ProjetoHotel.entity.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    ServicoDTO toDTO(Servico entity);

    @Mapping(target = "id", ignore = true)
    Servico toEntity(ServicoDTO dto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDTO(ServicoDTO dto, @MappingTarget Servico entity);

    List<ServicoDTO> toDTOList(List<Servico> entities);
}