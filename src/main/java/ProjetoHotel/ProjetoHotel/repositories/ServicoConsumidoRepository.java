package ProjetoHotel.ProjetoHotel.repositories;

import ProjetoHotel.ProjetoHotel.entity.ServicoConsumido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoConsumidoRepository extends JpaRepository<ServicoConsumido, Long> {
}