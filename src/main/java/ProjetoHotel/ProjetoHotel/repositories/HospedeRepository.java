package ProjetoHotel.ProjetoHotel.repositories;

import ProjetoHotel.ProjetoHotel.entity.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospedeRepository extends JpaRepository<Hospede, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
}