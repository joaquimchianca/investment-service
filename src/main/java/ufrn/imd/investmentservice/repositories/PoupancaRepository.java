package ufrn.imd.investmentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ufrn.imd.investmentservice.models.Poupanca;

import java.math.BigDecimal;

@Repository
public interface PoupancaRepository extends JpaRepository<Poupanca, Long> {

    @Modifying
    @Query("UPDATE Poupanca p SET p.montante = p.montante + (p.montante * :valor)")
    void rendimento(@Param("valor") BigDecimal taxa);
}
