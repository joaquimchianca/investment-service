package ufrn.imd.investmentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ufrn.imd.investmentservice.models.InvestimentoTesouroDireto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface InvestimentoTesouroDiretoRepository extends JpaRepository<InvestimentoTesouroDireto, Long> {
    @Query(value = "SELECT * FROM investimento_tesouro_direto as i where i.titulo_id = :titulo_id and i.usuario_id = :user_id", nativeQuery = true)
    InvestimentoTesouroDireto findByUsuarioIdAndTituloId(@Param("user_id") Long usuarioId,@Param("titulo_id") Long tituloId);

    List<InvestimentoTesouroDireto> findByCreatedAtGreaterThanAndCreatedAtLessThan(LocalDate start, LocalDate end);
}
