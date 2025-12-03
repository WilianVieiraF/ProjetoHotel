package ProjetoHotel.ProjetoHotel.repositories;

import ProjetoHotel.ProjetoHotel.entity.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    // Additional query methods can be defined here if needed
}