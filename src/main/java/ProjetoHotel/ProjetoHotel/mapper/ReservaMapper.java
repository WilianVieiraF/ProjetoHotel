package ProjetoHotel.ProjetoHotel.mapper;

import ProjetoHotel.ProjetoHotel.dto.ReservaDTO;
import ProjetoHotel.ProjetoHotel.entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(source = "hospede.id", target = "hospede.id")
    @Mapping(source = "hospede.nome", target = "hospede.nome")
    @Mapping(source = "quarto.id", target = "quarto.id")
    @Mapping(source = "quarto.numero", target = "quarto.nome") // Corrected mapping
    ReservaDTO toDTO(Reserva entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataReserva", ignore = true)
    @Mapping(target = "hospede", ignore = true)
    @Mapping(target = "quarto", ignore = true)
    Reserva toEntity(ReservaDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataReserva", ignore = true)
    @Mapping(target = "hospede", ignore = true)
    @Mapping(target = "quarto", ignore = true)
    void updateEntityFromDTO(ReservaDTO dto, @MappingTarget Reserva entity);

    List<ReservaDTO> toDTOList(List<Reserva> entities);
}