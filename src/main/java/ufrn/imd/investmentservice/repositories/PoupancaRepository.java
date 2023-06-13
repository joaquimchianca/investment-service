package ufrn.imd.investmentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufrn.imd.investmentservice.models.Poupanca;

@Repository
public interface PoupancaRepository extends JpaRepository<Poupanca, Long> {
}
