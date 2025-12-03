package ProjetoHotel.ProjetoHotel.repositories;

import ProjetoHotel.ProjetoHotel.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {
}